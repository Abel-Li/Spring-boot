package com.lyc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.lyc.dao.IRedisService;

@Service
public class RedisServiceImpl implements IRedisService {
	
	@Autowired
	private RedisTemplate<String, ?> redisTemplate;
	
	@Override
	public boolean set(final String key, final String value) {  
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            @Override  
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                connection.set(serializer.serialize(key), serializer.serialize(value));  
                return true;  
            }  
        });  
        return result;  
    }

	@Override
	public String get(final String key){  
        String result = redisTemplate.execute(new RedisCallback<String>() {  
            @Override  
            public String doInRedis(RedisConnection connection) throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                byte[] value =  connection.get(serializer.serialize(key));  
                return serializer.deserialize(value);  
            }  
        });  
        return result;  
    }

	@Override
	public boolean expire(String key, long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean setList(String key, List<T> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> List<T> getList(String key, Class<T> clz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long lpush(String key, Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long rpush(String key, Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String lpop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
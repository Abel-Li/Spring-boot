package com.lyc.dao;

import java.util.List;

import com.lyc.model.User;

public interface  UserMapperDao {
	//findUserInfo
	public User findUserInfo(int age);
	
	//getAllUserInfo
	public List<User> getAllUserInfo();
	
}

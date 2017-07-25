package com.lyc.controller;
 

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lyc.dao.UserMapperDao;
import com.lyc.model.User;
 
@Controller
public class UserController {
 
    private Logger logger = Logger.getLogger(UserController.class);
 
    @Autowired
    private UserMapperDao userMapperDao;
 
    @RequestMapping("/getAllUserInfo")
    @ResponseBody
    public List<User> getAllUserInfo() {
    	List<User> user = userMapperDao.getAllUserInfo();
        if(user!=null){
        	System.out.println("size:"+user.size());
        	logger.info("size:"+user.size());
        }
        return user;
    }
    
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
    	int age = Integer.parseInt(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getParameter("age"));
    	
        User user = userMapperDao.findUserInfo(age);
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }
}
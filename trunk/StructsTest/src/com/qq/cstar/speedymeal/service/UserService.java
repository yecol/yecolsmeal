package com.qq.cstar.speedymeal.service;

import com.qq.cstar.speedymeal.dao.UserDao;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.util.MD5;

public class UserService {
	
	private UserDao userDao=new UserDao();
	
	public User loginByUsername(String username,String pwd){
		//登录
		User user=userDao.getUniqueUserByName(username);
		if(user!=null&&user.getPwd().equals(MD5.getMD5(pwd))){
			user.setPwd(null);
			return user;
			//当用户名和密码正确时登录成功，设空密码并返回对象
		}
		else return null;
		//登录失败
	}

}

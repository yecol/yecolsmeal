package com.qq.cstar.speedymeal.service;

import com.qq.cstar.speedymeal.dao.UserDao;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.util.MD5;

public class UserService {
	
	private UserDao userDao=new UserDao();
	
	public User loginByUsername(String username,String pwd){
		//��¼
		User user=userDao.getUniqueUserByName(username);
		if(user!=null&&user.getPwd().equals(MD5.getMD5(pwd))){
			user.setPwd(null);
			return user;
			//���û�����������ȷʱ��¼�ɹ���������벢���ض���
		}
		else return null;
		//��¼ʧ��
	}

}

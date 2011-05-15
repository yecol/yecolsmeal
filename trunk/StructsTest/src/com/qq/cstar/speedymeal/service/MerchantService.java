package com.qq.cstar.speedymeal.service;

import com.qq.cstar.speedymeal.dao.MerchantDao;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.util.MD5;

public class MerchantService {
	
	private MerchantDao merchantDao=new MerchantDao();

	public Merchant loginByUsername(String username, String pwd) {
		Merchant merchant=merchantDao.getUniqueUserByName(username);
		if(merchant!=null&&merchant.getPwd().equals(MD5.getMD5(pwd))){
			merchant.setPwd(null);
			return merchant;
			//当商户登录的用户名和密码正确时登录成功，设空密码并返回对象
		}
		else return null;
	}

	public Merchant registerMerchant(Merchant merchant) {
		Merchant registeredMerchant=merchantDao.insertMerchant(merchant);
		if(registeredMerchant!=null){
			registeredMerchant.setPwd(null);
			return registeredMerchant;
			//当注册成功，设空密码并返回对象
		}
		else return null;
		//注册失败，返回空对象
	}
	
	public boolean addNewBranch(Branch branch){
		//添加新的分店信息
		return true;
	}

}

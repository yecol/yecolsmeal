package com.qq.cstar.speedymeal.service;

import java.util.ArrayList;

import com.qq.cstar.speedymeal.dao.MerchantDao;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.util.MD5;

public class MerchantService {

	private MerchantDao merchantDao = new MerchantDao();

	// 商户使用用户名登录
	public Merchant loginByUsername(String username, String pwd) {
		Merchant merchant = merchantDao.getUniqueUserByName(username);
		// 密码比对
		if (merchant != null && merchant.getPwd().equals(MD5.getMD5(pwd))) {
			merchant.setPwd(null);
			return merchant;
			// 当商户登录的用户名和密码正确时登录成功，设空密码并返回对象
		} else
			return null;
	}

	// 商户注册
	public Merchant registerMerchant(Merchant merchant) {
		Merchant registeredMerchant = merchantDao.insertMerchant(merchant);
		if (registeredMerchant != null) {
			registeredMerchant.setPwd(null);
			return registeredMerchant;
			// 当注册成功，设空密码并返回对象
		} else
			return null;
		// 注册失败，返回空对象
	}

	// 得到商户的完整信息
	public Merchant getFullInfoMerchantByMid(int mid) {
		Merchant merchant = merchantDao.getMerchantByMid(mid);
		return merchant;
	}

	// 获得所有分店信息
	public ArrayList<Branch> getAllBranches(int mid) {
		ArrayList<Branch> branches = merchantDao.getBranchesByMid(mid);
		return branches;
	}

	// 添加新的分店信息
	public boolean addNewBranch(Branch branch) {
		if (branch != null) {
			return merchantDao.InsertBranch(branch);
		} else
			return false;
	}

	// 删除分店信息
	public boolean delBranch(int bid) {
		return merchantDao.delBranch(bid);
	}

}

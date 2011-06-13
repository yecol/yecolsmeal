package com.qq.cstar.speedymeal.service;

import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Menu;
import com.qq.cstar.speedymeal.dao.MenuDao;
import com.qq.cstar.speedymeal.dao.MerchantDao;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.util.MD5;

public class MerchantService {

	private MerchantDao merchantDao = new MerchantDao();
	private MenuDao menuDao = new MenuDao();

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
		if (merchantDao.insertMerchant(merchant)) {
			// 当注册成功，设空密码并返回对象
			merchant.setPwd(null);
			return merchant;
		} else {
			return null;
		}
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

	// 获得菜单
	public ArrayList<Menu> getMenus(int mid) {
		ArrayList<Menu> menus = menuDao.getMenusByMid(mid);
		return menus;
	}

	public boolean addNewMenu(Menu menu) {
		return menuDao.insertMenu(menu);
	}

	public boolean delMenu(int meid) {
		return menuDao.delMenu(meid);
	}

}

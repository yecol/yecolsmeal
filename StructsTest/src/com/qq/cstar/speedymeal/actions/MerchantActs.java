package com.qq.cstar.speedymeal.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.service.MerchantService;

public class MerchantActs extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Merchant merchant;
	private MerchantService merchantService = new MerchantService();

	public String login() {
		// 商户登录
		merchant = merchantService.loginByUsername(merchant.getUsername(), merchant.getPwd());
		if (merchant != null) {
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

	public String register() {
		// 商户注册
		merchant = merchantService.registerMerchant(merchant);
		if (merchant != null) {
			return "register-success";
		} else {
			addActionError("用户名已存在,请重新选择用户名!");
			return LOGIN;
		}
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}
}

package com.qq.cstar.speedymeal.service;

import java.util.ArrayList;

import com.qq.cstar.speedymeal.dao.MerchantDao;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.util.MD5;

public class MerchantService {

	private MerchantDao merchantDao = new MerchantDao();

	// �̻�ʹ���û�����¼
	public Merchant loginByUsername(String username, String pwd) {
		Merchant merchant = merchantDao.getUniqueUserByName(username);
		// ����ȶ�
		if (merchant != null && merchant.getPwd().equals(MD5.getMD5(pwd))) {
			merchant.setPwd(null);
			return merchant;
			// ���̻���¼���û�����������ȷʱ��¼�ɹ���������벢���ض���
		} else
			return null;
	}

	// �̻�ע��
	public Merchant registerMerchant(Merchant merchant) {
		Merchant registeredMerchant = merchantDao.insertMerchant(merchant);
		if (registeredMerchant != null) {
			registeredMerchant.setPwd(null);
			return registeredMerchant;
			// ��ע��ɹ���������벢���ض���
		} else
			return null;
		// ע��ʧ�ܣ����ؿն���
	}

	// �õ��̻���������Ϣ
	public Merchant getFullInfoMerchantByMid(int mid) {
		Merchant merchant = merchantDao.getMerchantByMid(mid);
		return merchant;
	}

	// ������зֵ���Ϣ
	public ArrayList<Branch> getAllBranches(int mid) {
		ArrayList<Branch> branches = merchantDao.getBranchesByMid(mid);
		return branches;
	}

	// ����µķֵ���Ϣ
	public boolean addNewBranch(Branch branch) {
		if (branch != null) {
			return merchantDao.InsertBranch(branch);
		} else
			return false;
	}

	// ɾ���ֵ���Ϣ
	public boolean delBranch(int bid) {
		return merchantDao.delBranch(bid);
	}

}

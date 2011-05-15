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
			//���̻���¼���û�����������ȷʱ��¼�ɹ���������벢���ض���
		}
		else return null;
	}

	public Merchant registerMerchant(Merchant merchant) {
		Merchant registeredMerchant=merchantDao.insertMerchant(merchant);
		if(registeredMerchant!=null){
			registeredMerchant.setPwd(null);
			return registeredMerchant;
			//��ע��ɹ���������벢���ض���
		}
		else return null;
		//ע��ʧ�ܣ����ؿն���
	}
	
	public boolean addNewBranch(Branch branch){
		//����µķֵ���Ϣ
		return true;
	}

}

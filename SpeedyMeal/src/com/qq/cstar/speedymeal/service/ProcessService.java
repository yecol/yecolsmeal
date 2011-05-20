package com.qq.cstar.speedymeal.service;

import java.util.ArrayList;

import com.qq.cstar.speedymeal.dao.MerchantDao;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;

public class ProcessService {
	
	private MerchantDao merchantDao = new MerchantDao();
	
	public ArrayList<Branch> getAvailableBranches(Location location){
		ArrayList<Branch> branches = merchantDao.getAllBranches();  
		//TODO ������д�㷨ʹ��location��branches����ɸѡ��
		return branches;
	}

	

}

package com.amazon1.service;

import com.amazon1.dao.AmazonDao;
import com.amazon1.dao.AmazonDaoInterface;
import com.amazon1.dao.DaoInterface;
import com.amazon1.dao.clintDao;
import com.amazon1.entity.Customer;

public class LoginService implements LoginServiceInterface{

	public static LoginServiceInterface createServiceObject() {
		
		return new LoginService();
	}

	@Override
	public int LoginSucess(Customer ls) {
		DaoInterface ad=clintDao.createDaoObject();
		return ad.createProfileDao(ls) ;
	}

}

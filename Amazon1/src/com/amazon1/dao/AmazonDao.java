package com.amazon1.dao;

public class AmazonDao implements AmazonDaoInterface{
	
	public static AmazonDaoInterface createDaoObject() {
		
		return new AmazonDao();
	}

	@Override
	public int createProfileDao(String ac) {
		
		return 1;
	}

}

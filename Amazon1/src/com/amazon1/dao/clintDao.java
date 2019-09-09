package com.amazon1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.amazon1.entity.Customer;

public class clintDao implements DaoInterface 
{

	public static DaoInterface createDaoObject() 
	{
		
		return new clintDao();
	}

	@Override
	public int createProfileDao(Customer ls) 
	{
		boolean status ;
		int i=0;
		try
		{
			
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:/Zensar1");
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from amazone wehere name=? and pass=?");
			ps.setString(1, ls.getName());
			ps.setString(2, ls.getPass());
			ResultSet rs=ps.executeQuery();  
			status=rs.next();
			if(status==true)
			{
				i=1;
		     }
			else
			{
				i=0;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
		}
	
	
}

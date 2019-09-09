package com.amazon1.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.amazon1.entity.Amazon1Customer;

public class AmazonDao implements AmazonDaoInterface{
	private AmazonDao(){}
	
	public static AmazonDaoInterface createDaoObject() {
		
		return new AmazonDao();
	}

	@Override
	public int createProfileDao(Amazon1Customer ac) {
		
		int i=0;
		try{
			//Properties props=new Properties();
			//props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory" );
			//props.put(Context.PROVIDER_URL,"localhost:8080");
			//props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:/Zensar1");
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into amazone values(?,?,?,?)");
			ps.setString(1, ac.getName());
			ps.setString(2, ac.getPass());
			ps.setString(3, ac.getEmail());
			ps.setString(4, ac.getAdddress());
			i=ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	

}

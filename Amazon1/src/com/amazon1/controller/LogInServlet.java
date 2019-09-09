package com.amazon1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon1.entity.Customer;
import com.amazon1.service.LoginService;
import com.amazon1.service.LoginServiceInterface;


public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/Html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String option=request.getParameter("li");
		if(option.equals("logIn"))
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			Customer ls=new Customer(); 
			ls.setName(name);
			ls.setPass(pass);
			LoginServiceInterface li=LoginService.createServiceObject();
			int i=li.LoginSucess(ls);
			if(i>0) {
				out.println("profile created");
			}
			else
			{
				out.println("profile not created");
			}
			out.println("<a href='Home.html'>Home</a>");
			out.close();
		}
	}

}

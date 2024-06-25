package com.demo.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.connection.myConnection;
import com.demo.dao.userDao;
import com.demo.model.user;

public class register_servlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		user u=new user();
		u.setName(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		u.setPassword(req.getParameter("password"));
		userDao ud=new userDao(myConnection.getConnection());
		int check=ud.register(u);
		HttpSession session=req.getSession();
		if(check>0)
		{
			session.setAttribute("success_msg", "user registered successfully");
			resp.sendRedirect("login.jsp");
			System.out.println("registered successfully");
		}
		else
		{
			session.setAttribute("error_msg", "something went wrong");
			resp.sendRedirect("register.jsp");
			System.out.println("error occured");
		}
	}

}

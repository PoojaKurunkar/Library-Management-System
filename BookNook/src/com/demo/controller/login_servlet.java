
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
public class login_servlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		userDao ud=new userDao(myConnection.getConnection());
		user u=ud.loginUser(email, password);
		HttpSession session=req.getSession();
		if(u!=null)
		{
			session.setAttribute("user",u);
			resp.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("invalidMsg","Invalid email and password");
			resp.sendRedirect("login.jsp");
		}
	}

}
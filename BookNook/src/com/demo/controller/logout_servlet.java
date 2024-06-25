
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
public class logout_servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session=req.getSession();
		session.removeAttribute("user");
		HttpSession session1=req.getSession();
		session.setAttribute("logoutMsg","Logout Successfully");
			resp.sendRedirect("login.jsp");
}
}
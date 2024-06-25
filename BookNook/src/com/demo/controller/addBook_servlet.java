package com.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.connection.myConnection;
import com.demo.dao.bookDao;
import com.demo.model.book;

public class addBook_servlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		book c=new book();
		c.setAuthorName(req.getParameter("authorName"));
		c.setDescription(req.getParameter("description"));
		c.setPublisher(req.getParameter("publisher"));
		c.setTitle(req.getParameter("title"));
		c.setUserId(Integer.parseInt(req.getParameter("userId")));
		
		bookDao cd=new bookDao(myConnection.getConnection());
		HttpSession session=req.getSession();
		int check=cd.saveBook(c);
		if(check>0)
		{
			session.setAttribute("successMsg","Your record of book Saved Successfully...");
			resp.sendRedirect("addBook.jsp");
		}
		else
		{
			session.setAttribute("failedMsg","Something Wrong On Server Side...");
			resp.sendRedirect("addBook.jsp");
			
		}
		
	}

}

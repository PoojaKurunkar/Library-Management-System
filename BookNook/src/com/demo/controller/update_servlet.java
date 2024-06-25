package com.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.connection.myConnection;
import com.demo.dao.bookDao;
import com.demo.dao.userDao;
import com.demo.model.book;
import com.demo.model.user;

public class update_servlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
	int cid=Integer.parseInt(req.getParameter("cid"));
	book c=new book();
	c.setId(cid);
	c.setTitle(req.getParameter("title"));
	c.setDescription(req.getParameter("description"));
	c.setAuthorName(req.getParameter("authorName"));
	c.setPublisher(req.getParameter("publisher"));

	bookDao cd=new bookDao(myConnection.getConnection());
	
	HttpSession session=req.getSession();
	int check=cd.update(c);
	if(check>0)
	{
		session.setAttribute("successMsg","Your record of book updated Successfully...");
		resp.sendRedirect("viewBook.jsp");
	}
	else
	{
		session.setAttribute("failedMsg","Something Wrong On Server Side...");
		resp.sendRedirect("edit.jsp?cid="+cid);
		
	}
	
}

}

package com.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.connection.myConnection;
import com.demo.dao.bookDao;

public class delete_servlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=Integer.parseInt(req.getParameter("cid"));
		bookDao cd=new bookDao(myConnection.getConnection());
		int check=cd.delete(cid);

		HttpSession session=req.getSession();
		if(check>0)
		{
			session.setAttribute("successMsg","Record Of book deleted Successfully...");
			resp.sendRedirect("viewBook.jsp");
		}
		else
		{
			session.setAttribute("failedMsg","Something Wrong On Server Side...");
			resp.sendRedirect("viewBook.jsp");
			
		}
		
	}

}

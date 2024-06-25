
package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.connection.myConnection;
import com.demo.model.book;
public class bookDao {

	private Connection con;
	
	public bookDao() {
		super();
	}

	public bookDao(Connection con) {
		super();
		this.con = con;
	}

	public int saveBook(book c) {
		int check = 0;
		String sql = "insert into book(title,authorName,publisher,description,userId) values(?,?,?,?,?)";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, c.getTitle());
			pst.setString(2, c.getAuthorName());
			pst.setString(3, c.getPublisher());
			pst.setString(4, c.getDescription());
			pst.setInt(5, c.getUserId());
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public List<book> getAllBook(int uId)
	{
		List<book> list=new ArrayList<book>();
		book c=null;
		try
		{
			String sql="select id,title,authorName,publisher,description from book where userId=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, uId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				c=new book();
				c.setId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setAuthorName(rs.getString(3));
				c.setPublisher(rs.getString(4));
				c.setDescription(rs.getString(5));
				list.add(c);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return list;
	}
	
	public book getBookById(int cid)
	{
		book c=null;
		ResultSet rs=null;
		try
		{
			String sql="select * from book where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, cid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				c=new book();
				c.setId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setAuthorName(rs.getString(3));
				c.setPublisher(rs.getString(4));
				c.setDescription(rs.getString(5));
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return c;
	}
	public int update(book c) {
		int check=0;
		try {
			String sql = "update book set title=?,authorName=?,publisher=?,description=? where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getTitle());
			pst.setString(2, c.getAuthorName());
			pst.setString(3, c.getPublisher());
			pst.setString(4, c.getDescription());
			pst.setInt(5, c.getId());
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public int delete(int id) {
		int check=0;
		try {
			String sql = "delete from book where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

}


package com.demo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.demo.connection.myConnection;
import com.demo.model.user;
public class userDao {

	private Connection con;
	
	public userDao() {
		super();
	}

	public userDao(Connection con) {
		super();
		this.con = con;
	}

	public int register(user u) {
		int check = 0;
		String sql = "insert into user(name,email,password) values(?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public user loginUser(String email,String password)
	{
		int check=0;
		user u=null;
		ResultSet rs=null;
		String sql="select id,name,email,password from user where email=? and password=?";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2,password);
			rs=pst.executeQuery();
			while(rs.next())
			{
				u=new user();
				u.setId((int)rs.getObject("id"));
				u.setName((String)rs.getObject("name"));
				u.setEmail((String)rs.getObject("email"));
				u.setPassword((String)rs.getObject("password"));
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return u;
		
		
	}
}


package com.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {
	private static Connection con;
	public static Connection getConnection() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", null);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;

	}
}

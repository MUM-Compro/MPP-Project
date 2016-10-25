package edu.mum.foods;

import java.sql.*;

public class Connection {

	// Database connection constant
	private static String url = "jdbc:mysql://localhost/food";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "root";
	private static java.sql.Connection conn;

	// Method connect to mysql database
	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Successful connected!!!");
		} catch (ClassNotFoundException ex) {
			System.out.println("Cannot connect to database!");
		}
		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		getConnection();

	}

}

package edu.mum.food.model;

import java.sql.*;

/**
 * @author Sovichea Cheth - 985421
 * @version 1.0
 * @since 09/20/2016
 * @description this class use to connect to mysql database using jdbc other
 *              class can call connection method as required
 */

public class Connection {

	// Database connection constant
	private static String url = "jdbc:mysql://localhost:3306/food";
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

package edu.mum.foods;

import java.sql.SQLException;
import java.sql.Statement;

public class RegisterUser {
	
	public static void getRegister(String firstname, String lastname, String email,
			String password, String gender, String address, String contact_name, String status) throws ClassNotFoundException, SQLException{
		
		
		
		String query = "INSERT INTO tblPerson (firstname, lastname, email, password, gender, address, contact_number, access_level, status) VALUES('"+firstname+"','"+lastname+"','"+email+"','"+password+"','"+
				gender+"','"+address+"','"+contact_name+"','"+status+"',2)";
		
		
		try {
			
			Statement stmt = Connection.getConnection().createStatement();
			stmt.executeUpdate(query);
			System.out.println("im here");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Connection.getConnection().close();
		}
		
		
	}

}

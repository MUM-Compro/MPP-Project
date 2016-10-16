package edu.mum.foods;

import java.sql.SQLException;
import java.sql.Statement;

public class RegisterUser {
	
	public static void getRegister(String firstname, String lastname, String email,
			String password, String gender, String address, String contact_name,
			String access_level, int status) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO tblPerson (firstname, lastname, email, password, gender, address, contact_number, access_level) VALUES('"+firstname+"','"+lastname+"','"+email+"','"+password+"','"+
				gender+"','"+address+"','"+contact_name+"','"+access_level+")";
		
		
		try {
			Statement stmt = Connection.getConnection().createStatement();
			stmt.executeUpdate(query);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Connection.getConnection().close();
		}
		
		
	}

}

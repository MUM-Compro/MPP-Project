package edu.mum.foods;

import java.sql.SQLException;
import java.sql.Statement;

public class RegisterFood {
	
	public static void getRegisterFood(String foodname, String category, String description, String price, String img) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO tblItems (item_name, identifier, description, price, image) VALUES('"+foodname+"','"+category+"','"+description+"','"+price+"','"+img+"')";
		
		
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

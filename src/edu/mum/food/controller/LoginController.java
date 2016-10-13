package edu.mum.food.controller;

import edu.mum.food.view.*;

import java.sql.*;

public class LoginController {
	
	private String uname;
	private String pass;
	
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/food";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      //STEP 4: Execute a query
      stmt = conn.createStatement();

      String sql = "SELECT cid, email, password FROM tblperson";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int cid  = rs.getInt("cid");
         String email = rs.getString("email");
         String password = rs.getString("password");

         //Display values
         System.out.print("CID: " + cid + "\n");
         System.out.print("email: " + email + "\n");
         System.out.print("password: " + password);
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end main
}
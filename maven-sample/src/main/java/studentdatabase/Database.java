package studentdatabase;

import java.sql.*;

public class Database {
	 public Connection con;
    public Database() {
    	  try{
              Class.forName("com.mysql.jdbc.Driver");  
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/S_M_S","root","Kasun#1234"); 
               System.out.println("Succesfull connection........");
          }catch(Exception e){
          System.out.print(e);
          
                  } 
      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database obj = new Database();

	}

}

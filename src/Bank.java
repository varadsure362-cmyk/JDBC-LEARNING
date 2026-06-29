import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Scanner;





public class Bank {
	public static void main(String args[]) {
		String url="jdbc:mysql://localhost:3308/Bank";
		String un="root";
		String pwd="varad@123";
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver connected");
			Connection con=DriverManager.getConnection(url,un,pwd);
			  System.out.println("Database connected");
			  Scanner sc=new Scanner(System.in);
			  System.out.println("-----Showing balance----");
			  //BALANCE SHOWING MODULE
			  System.out.println("enter a name :");
			  String name=sc.next();
			  System.out.println("enter a pin :");
			  int pin=sc.nextInt();
			  
			  String query="select * from details where name=? and pin=?";
			  PreparedStatement stmt=con.prepareStatement(query);
			  stmt.setInt(2,pin);
			  stmt.setString(1,name);
			  ResultSet res=stmt.executeQuery();
			  res.next();
			
			  int balance=res.getInt(3);
			  
			System.out.println("balance is :"+ balance);
			//TRANSFER MODULE
			
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("driver not loaded");
			e.printStackTrace();
			
			
		}catch(SQLException e) {
			System.out.println("database not connected");
			e.printStackTrace();
		}
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Demo {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3308/Employee";
		String un="root";
		String pwd="varad@123";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver successfully loaded");
		
		Connection con=DriverManager.getConnection(url,un,pwd);
		System.out.println("connection established successfully ");
		
		//creating statment to send query from java to sql
//		Statement stat=con.createStatement();
//		String query="select * from emp";
//		
//		ResultSet res=stat.executeQuery(query);
//		System.out.println("query executed");
//		
//		while(res.next()==true)
//		{
//		System.out.println(res.getInt("id") + " "+ res.getString("name")+" " +res.getInt("salary"));
//		}
		// scorllable from bottom to start
//		Statement stat=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
//		String query="select * from emp";
//		
//		ResultSet res=stat.executeQuery(query);
//		System.out.println("query executed");
//		res.first();
//		System.out.println(res.getInt("id") + " "+ res.getString("name")+" " +res.getInt("salary"));
		
//		// accessing and row by using absolute
//		res.absolute(2);
//		
//		System.out.println(res.getInt("id") + " "+ res.getString("name")+" " +res.getInt("salary"));
		
//		//getting metaData means you get information about database by using metaData
//		ResultSetMetaData metaData=res.getMetaData();
//		for(int i=1;i<=metaData.getColumnCount();i++)
//		{
//		System.out.println(metaData.getColumnName(i)+" "+metaData.getColumnTypeName(i));
//		}
		
		// insert into sql table contant by using java(INSERTION)
		Statement stat=con.createStatement();
		 //use backtics compulasry other wise get error
		
//		String query1="insert into emp (`id`,`name`,`salary`) values (04,'chaitan',66866)";
//		stat.execute(query1);
//		System.out.println("query inserted successfully");
//		
//		//BATCH PROCESSING(VERY IMPORT) IT WILL REDUCE THE HITTING OF HARDWARE 
//		EVERYTIME WHEN WE ARE INSERTING MULTIPLE VALUES INTO THE TABLE
		
//		String query2="insert into emp (`id`,`name`,`salary`) values (05,'om',66866)";
//		String query3="insert into emp (`id`,`name`,`salary`) values (06,'om1',66866)";
//		String query4="insert into emp (`id`,`name`,`salary`) values (07,'om2',66866)";
//		String query5="insert into emp (`id`,`name`,`salary`) values (08,'om3',66866)";
//		stat.addBatch(query2);
//		stat.addBatch(query3);
//		stat.addBatch(query4);
//		stat.addBatch(query5);
//		String query6="insert into emp (`id`,`name`,`salary`) values (09,'chaitan H',0000)";
//		stat.execute(query6);
//		
//		stat.executeBatch();
//		System.out.println("Batch executed successfully");
		
		//BASED ON USER INPUT TAKEN AND STORED INTO DATABASE
//		String query="insert into emp(`id`,`name`,`salary`) values (?,?,?)";
//		PreparedStatement pstmt=con.prepareStatement(query);
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter id");
//		int id =sc.nextInt();
//		System.out.println("enter name");
//		String name =sc.next();
//		System.out.println("enter salary");
//		int salary =sc.nextInt();
//		
//		pstmt.setInt(1,id);
//		pstmt.setString(2,name);
//		pstmt.setInt(3,salary);
//		pstmt.execute();
//		System.out.println("added successfully");
		
		//To maintain ACID PROPERTIES and of autocommit which maintain consistency 
//		in database either full all queries are executed neither no query is executed
//		String query="insert into emp(`id`,`name`,`salary`)values(?,?,?)";
//		PreparedStatement pstmt=con.prepareStatement(query);
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the no of rows");
//		int n=sc.nextInt();
//		con.setAutoCommit(false);
//		for(int i=1;i<=n;i++) {
//		System.out.println("Enter id");
//		int id=sc.nextInt();
//		System.out.println("Enter name");
//		String name=sc.next();
//		System.out.println("Enter salary");
//		int salary=sc.nextInt();
//		pstmt.setInt(1,id);
//		pstmt.setString(2,name);
//		pstmt.setInt(3,salary);
//		pstmt.execute();
//		
//		}
//		con.commit();
//		System.out.println("Commited");
		
		// UPDATE QUERY
		String query="update emp set salary=salary+salary*25/100";
		System.out.println("no of rows upaded : "+stat.executeUpdate(query));
		
		
		//DELETE DETAILS FROM SQL DATABASE
		String query1="delete from emp where name='chaitan'";
		System.out.println("no of rows Deleted : "+stat.executeUpdate(query1));
		
		
		
		
	
		stat.close();
		con.close();
		
		}
		catch(ClassNotFoundException e){
			System.out.println("driver not loaded");
			
			
		}catch(SQLException e) {
			System.out.println("sql not connected");
			e.printStackTrace();
			
			
		}
	}

}

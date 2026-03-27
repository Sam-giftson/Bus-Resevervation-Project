import java.sql.*;

public class JDBCDemo {

	public static void main(String[] args) throws Exception{
		
//		readRecords();
//		insertRecords();
//		insertVar();
//		insertUsingPst();
//		update();
		sp3();
	}
	
	public static void readRecords()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		String query="select * from employee";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
		System.out.println("Id is " + rs.getInt(1));
		System.out.println("Name is " + rs.getString(2));
		System.out.println("Salary is " + rs.getInt(3));}
		
		con.close();	
	}
	
	public static void insertRecords()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		String query="insert into employee values (4,'priya',250000)";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("Number of rows affected: " + rows);
		
		con.close();	
	}
	
	public static void insertUsingPst()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		
		int id = 6;
		String name="Jones";
		int salary = 700000;
		String query="insert into employee values (?,?,?);";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,id);
		pst.setString(2, name);
		pst.setInt(3, salary);
		
		int rows= pst.executeUpdate();
		System.out.println("Number of rows affected  :" + rows);
		
		con.close();	
	}
	
	public static void delete()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		
		int id=6;
//		String name="jones";
//		int salary = 700000;
		String query="delete from employee where emp_id ="+id;
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("Number of rows affected: " + rows);
		
		con.close();	
	}
	
	public static void update()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		
//		int id=6;
//		String name="jones";
//		int salary = 700000;
		String query="update employee set salary =150000 where emp_id=1";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("Number of rows affected: " + rows); 
		
		con.close();	
	}
	
	//calling simple stored procedure
	public static void sp()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";

		
		Connection con=DriverManager.getConnection(url,username,password);
		CallableStatement cst = con.prepareCall("{call GetEmp()}");
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
		System.out.println("Id is " + rs.getInt(1));
		System.out.println("Name is " + rs.getString(2));
		System.out.println("Salary is " + rs.getInt(3));}
		
		con.close();	
	}
	
	//calling stored procedure with input parameter
	public static void sp2()throws Exception
	{
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		
		int id=3;
		
		Connection con=DriverManager.getConnection(url,username,password);
		CallableStatement cst = con.prepareCall("{call GetEmpById(?)}");
		cst.setInt(1, id);
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
		System.out.println("Id is " + rs.getInt(1));
		System.out.println("Name is " + rs.getString(2));
		System.out.println("Salary is " + rs.getInt(3));}
		
		con.close();	
	}	
	
	//calling stored procedure with out parameter
	public static void sp3()throws Exception
	{
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="TIGER";
		
		int id=3;
		
		Connection con=DriverManager.getConnection(url,username,password);
		CallableStatement cst = con.prepareCall("{call GetNameById(?,?)}");
		cst.setInt(1, id);
		cst.registerOutParameter(2, Types.VARCHAR);
		ResultSet rs = cst.executeQuery();
		
		
		con.close();	
	}
		
}
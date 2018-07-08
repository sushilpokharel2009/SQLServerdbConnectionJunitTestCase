package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

public class SimpleDBTest {
	
//	FOR SQL SERVER DATA CONNECTION JUNIT TEST CASES PURPOSE
//	com.microsoft.sqlserver.jdbc.SQLServerDriver[put this in class name]
//	Db server: GHFGHFHGFYUTYUT07.DQA.CAP.COM
//	port:1433
//	user:abc
//	password:1234
//	table names: ABCDE, QRST
	//DatabaseName:MAS_SAC
	
	
	//	private String url = "jdbc:sqlserver://GHFGHFHGFYUTYUT07.DQA.cap.com:1433;databaseName=DBNameLekhayaha", "DB_USER","DB_PASSWORD");

	private String url = "jdbc:sqlserver://GHFGHFHGFYUTYUT07.DQA.CAP.COM:1433;DatabaseName=MAS_SAC";
	private String username = "sushil";
	private String password = "pok";
	private Connection connection = null;

	@Before
	public void setUp() throws Exception {
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//connection = DriverManager.getConnection(url);
		connection =  DriverManager.getConnection(url, username, password);
	}

	@Test
	public void testDataBaseRetrieval() throws SQLException{
		
		//String query = "SELECT  checknumber, accountnumber, routingnumber from Test1 limit 7";
		//String query = "SELECT  top 10 checknumber, accountnumber, routingnumber from Test1";
		String query = "SELECT   checknumber, accountnumber, routingnumber from Test1";
		//SELECT  checknumber, accountnumber, routingnumber FROM tablename WHERE RowNumber BETWEEN 1 AND 20;
//		OR
//		SELECT checknumber, accountnumber, routingnumber  FROM (SELECT TOP 7 FROM Tablename ORDER BY Id) ORDER BY Id DESC
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("CheckNumber : "+rs.getString("checknumber") + " accountnumber : "+rs.getString("accountnumber")
				+" routingnumber : "+rs.getString("routingnumber"));
				
			}
			
			
		} catch (SQLException e) {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}

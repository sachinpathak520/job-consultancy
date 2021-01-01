package com.dest.dbcon;
import java.sql.*;


public class DBConnection {
	private static Connection con;
	static {
		try {
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			
		 con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	public static PreparedStatement getPrepStatement(String sql) throws SQLException {
			return con.prepareStatement(sql);
	}
	

}

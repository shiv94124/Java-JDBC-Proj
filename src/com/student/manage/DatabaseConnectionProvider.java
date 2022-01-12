package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionProvider {
	
	
	static Connection conn;
	
	public static Connection createConnection() {
		try {
			
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			String user = "root";
			String password = "Sau94@124";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			conn = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}

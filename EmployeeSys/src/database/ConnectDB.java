package database;

import java.sql.*;

public class ConnectDB{
	 
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "" );
		} catch (Exception e) {
			connection = null;
		}
		
		return connection;
	}

}

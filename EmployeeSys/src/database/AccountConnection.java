package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import classes.Employees;

public class AccountConnection {
	
	public AccountConnection() {}
	static Connection myconnection;
	static	Statement mystatement;
	static ResultSet rs;
	 
	public static boolean login ( String user , String pass ) {
		try {
			myconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "" );	
			mystatement=myconnection.createStatement();
			rs=mystatement.executeQuery("select * from admin where username='" + user + "' and password='"  + pass + "'"); 
			while (rs.next()) {	
				return true;
			}
			myconnection.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	return false;
	}
	public static Employees Emp_login ( String user , String pass ) {
		try {
			myconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "" );	
			mystatement=myconnection.createStatement();
			rs=mystatement.executeQuery("select * from employees where email='" + user + "' and password='"  + pass + "'"); 
			while (rs.next()) {	
				Employees em = new Employees();
				em.setFirstname(rs.getString("first_name"));
				em.setLastname(rs.getString("last_name"));
				em.setEmail(rs.getString("email"));
				em.setDob(rs.getString("dob"));
				em.setID(rs.getInt("eID"));
				em.setPhone(rs.getString("phone"));
				em.setPosition(rs.getString("position"));
				em.setSalary(rs.getDouble("salary"));
				return em;
			}
			myconnection.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	return null;
	}
}

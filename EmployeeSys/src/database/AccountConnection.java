package database;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import admin_ui.Home;

public class AccountConnection {
	
	public AccountConnection() {}
	static Connection myconnection;
	static	Statement mystatement;
	static ResultSet rs;
	 String admin="admin";
	 
	public boolean login ( String user , String pass ) {
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
}

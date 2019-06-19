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
			 rs=mystatement.executeQuery("select * from account"); 
			while (rs.next()) {			
				if(user.equals(rs.getString("username")) ) {
					if(pass.equals(rs.getString("password")) ) {
						if(admin.equals(rs.getString("type"))) {
							return true;
						}
					}else {
						System.out.println("Password not match!!!");  
					}
				}else {
					System.out.println("no account found!!");
					}
				}
			myconnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	return false;
	}
}

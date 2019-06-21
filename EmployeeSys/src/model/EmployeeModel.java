package model;

import java.util.*;

import database.ConnectDB;
import employeeClass.Employees;

import java.sql.*;

public class EmployeeModel {
	
	public static ArrayList<Employees> all() {
		
		try {
			ArrayList<Employees> list = new ArrayList<>();
			String sql = "select * from employees";
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employees e = new Employees();
				e.setFirstname(rs.getString("first_name"));
				e.setLastname(rs.getString("last_name"));
				e.setEmail(rs.getString("email"));
				e.setDob(rs.getString("dob"));
				e.setID(rs.getInt("eID"));
				e.setPhone(rs.getString("phone"));
				e.setPosition(rs.getString("position"));
				e.setSalary(rs.getDouble("salary"));
				list.add(e);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Employees find(int id) {
		Employees em = new Employees();
		try {
			String sql = "select * from employees where eID=?";

			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				em.setID(rs.getInt("eID"));
				em.setFirstname(rs.getString("first_name"));
				em.setLastname(rs.getString("last_name"));
				em.setEmail(rs.getString("email"));
				em.setDob(rs.getString("dob"));
				em.setPhone(rs.getString("phone"));
				em.setPosition(rs.getString("position"));
				em.setSalary(rs.getDouble("salary"));
			}
			return em;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static boolean create(Employees em) {
		try {
			
			String sql = "insert into employees (first_name, last_name, email, dob, phone, position, salary) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setString(1, em.getFirstname());
			ps.setString(2, em.getLastname());
			ps.setString(3, em.getEmail());
			ps.setString(4, em.getDob());
			ps.setString(5, em.getPhone());
			ps.setString(6, em.getPosition());
			ps.setDouble(7, em.getSalary());
			
			return ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Employees em) {
		
		try {
			String sql = "update employees set first_name=?, last_name=?, email=?, dob=?, phone=?, position=?, salary=? where eID=?";
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setString(1, em.getFirstname());
			ps.setString(2, em.getLastname());
			ps.setString(3, em.getEmail());
			ps.setString(4, em.getDob());
			ps.setString(5, em.getPhone());
			ps.setString(6, em.getPosition());
			ps.setDouble(7, em.getSalary());
			ps.setInt(8, em.getID());
			return ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean delete(int id) {
		try {
			String sql = "delete from employees where eID=?";
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

}










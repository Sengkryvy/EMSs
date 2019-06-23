package model;

import java.util.*;

import java.sql.*;


import database.ConnectDB;
import employeeClass.Permission;

public class PermissionModel {
	
	public static ArrayList<Permission> all() {
		String sql = "select * from permission";
		try {
			ArrayList<Permission> list = new ArrayList<>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Permission permission = new Permission(rs.getInt("eID"), rs.getString("type"),
						rs.getString("applyDate"), rs.getString("leavingDate"), rs.getString("reason"));
				permission.setId(rs.getInt("id"));
				permission.setStatus(rs.getString("status"));
				list.add(permission);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Permission> all(int id) {
		String sql = "select * from permission where eID='" + id + "'";
		try {
			ArrayList<Permission> list = new ArrayList<>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Permission permission = new Permission(rs.getInt("eID"), rs.getString("type"),
						rs.getString("applyDate"), rs.getString("leavingDate"), rs.getString("reason"));
				permission.setId(rs.getInt("id"));
				permission.setStatus(rs.getString("status"));
				System.out.println(permission.toString());
				list.add(permission);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}

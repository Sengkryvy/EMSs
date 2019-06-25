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
	
	public static boolean create(Permission p) {
		String sql = "insert into permission (eID, type, leavingDate, reason) values (?, ?, ?, ?)";
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setInt(1, p.geteID());
			ps.setString(2, p.getType());
			ps.setString(3, p.getLeavingDate());
			ps.setString(4, p.getReason());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Permission p) {
		String sql = "update permisson set type=?, leavingDate=?, reason=? where id=?";
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setString(1, p.getType());
			ps.setString(2, p.getLeavingDate());
			ps.setString(3, p.getReason());
			ps.setInt(4, p.getId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(int id) {
		try {
			String sql = "delete from permission where id=?";
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean accept(int id) {
		String sql = "update permission set status=? where id=?";
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setString(1, "Accepted");
			ps.setInt(2, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean reject(int id) {
		String sql = "update permission set status=? where id=?";
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(sql);
			ps.setString(1, "Rejected");
			ps.setInt(2, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

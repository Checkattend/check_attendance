package com.gdpi.attendance.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {
	Connection con;
	Statement stmt = null;
	ResultSet rs = null;
	String driverName = "com.mysql.jdbc.Driver";
	String userName = "root";
	String userPasswd = "root";
	String dbName;
	String url;

	public JDBConnection() {
		url = "jdbc:mysql://localhost:3306/attendance_sys?user=" + userName
				+ "&password=" + userPasswd
				+ "&useUnicode+true&characterEncoding=utf-8";
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println("连接数据库失败");
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * 3.执行SQL语句。
	 *3.1查询，并返回查询结果集
	*/
	public ResultSet executeQuery(String sql) {
		try {

			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}

	/**
	 * 3.2执行SQL更新，并返回影响到的记录条数
	*/
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			// Class.forName(driverName);
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
}
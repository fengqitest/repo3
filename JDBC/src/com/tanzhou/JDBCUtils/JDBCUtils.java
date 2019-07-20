package com.tanzhou.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc工具类，
 */
public class JDBCUtils {
	// 静态私有 一般工具类都是直接调用
	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;
	// 编写一个静态代码块
	static {
		driverClassName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql:///mybase";
		username = "root";
		password = "1234";
	}

	/**
	 * 注册驱动
	 */
	public static void loadDriver() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 获得连接
	 */
	public static Connection getconnection() {
		// 把connection放到外面
		Connection conn = null;
		try {
			//
			loadDriver();
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 */
	// 增删改
	public static void close(Connection conn, Statement st) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		conn = null;

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		st = null;
	}
	// 查

	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		conn = null;

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		st = null;

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		rs = null;

	}

}

package com.tanzhou.JDBCUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * jdbc工具类
 */
public class JDBCUtils2 {

	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;

	static {
		// 获取文本内容
		Properties properties = new Properties();
		try {
			// load方法 输入流
			properties.load(new FileInputStream("src//db.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverClassName = properties.getProperty("driverClassName");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");

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
	//
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
	// 处理

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

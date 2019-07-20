package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo_01 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, username, password);

		// SQL语句
		String sql = "SELECT * FROM sort";
		// 预编译对象
		PreparedStatement pst = con.prepareStatement(sql);

		// 调用pst对象的方法,执行查询语句,Select
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("sid") + "  " + rs.getString("sname") + "  " + rs.getString("sprice") + "  "
					+ rs.getString("sdesc"));
		}
		rs.close();
		pst.close();
		con.close();
	}

}

package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 演示SQL注入 
 * 
 */
public class Demo_03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接对象
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "liangchen";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3.获取执行语句
		Statement stat = con.createStatement();
		// 键盘录了
		Scanner sc = new Scanner(System.in);
		String user1 = sc.nextLine();
		String pass = sc.nextLine();
		// 4.执行SQL语句 查询用户名和密码
		String sql = "select * from user where username ='" + user1 + "+' and password ='" + pass + "'";
		System.out.println(sql);

		// 5.结果集
		ResultSet rs = stat.executeQuery(sql);
		// 遍历结果集
		while (rs.next()) {
			System.out.println(rs.getString("username") + "  " + rs.getString("password"));
		}
		//6. 关闭资源
		rs.close();
		stat.close();
		con.close();
	}
}

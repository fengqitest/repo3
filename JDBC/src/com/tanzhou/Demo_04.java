package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 防止SQL攻击
 * 表示预编译的 SQL 语句的对象。

  SQL 语句被预编译并存储在 PreparedStatement 对象中。然后可以使用此对象多次高效地执行该语句。
 */
public class Demo_04 {
	public static void main(String[] args) throws Exception {
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
		// 执行SQL语句 查询用户名和密码 Connection 调用PreparedStatement，获取接口的实现类
		// 执行SQL语句 查询用户名和密码 采用占位符 ？
		String sql = "select * from user where username =? and password =?";
		System.out.println(sql);
		// SQL语句的参数全部采用问号占位符
		PreparedStatement pstat = con.prepareStatement(sql);
		// 调用pstat对象的set方法，设置问号占位符上的参数
		pstat.setObject(1, user1);
		pstat.setObject(2, pass);

		// 获取结果集
		ResultSet rs = pstat.executeQuery();
		// 遍历结果集
		while (rs.next()) {

			System.out.println(rs.getString("username") + "  " + rs.getString("password"));
		}
		// 关闭资源
		rs.close();
		stat.close();
		con.close();
	}
}

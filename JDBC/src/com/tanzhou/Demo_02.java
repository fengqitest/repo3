package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc技术，查询数据表，获取结果集
 */
public class Demo_02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接对象
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "liangchen";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3.获取执行SQL语句对象
		Statement stat = con.createStatement();
		// 查询语句
		String sql = "select * from sort";
		// 4.调用执行者对象的方法，执行SQL语句 返回值ResultSet接口实现类的对象
		ResultSet rs = stat.executeQuery(sql);
		// 5.处理结果集 rssultset boolena next 返回true，有结果集 ，返回false则没有
		while (rs.next()) {
			// 获取每列数据，使用getxxx方法
			System.out.println(rs.getString("sid") + "   " + rs.getString("sname") + "  " + rs.getString("sprice")
					+ "  " + rs.getString("sdesc"));
		}

		// 6.关闭资源 先开后关的顺序
		rs.close();
		stat.close();
		con.close();

	}
}

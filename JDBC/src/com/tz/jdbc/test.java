package com.tz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得链接
			String url="jdbc:mysql://localhost:3306/user";
			String user="root";
			String password="123456";
			Connection conn = DriverManager.getConnection(url, user, password);
			//3.获得sql语句平台
			Statement stat = conn.createStatement();
			//编写sql语句
			String sql="insert into userform values(6,'小黄01',2000)";	
			//4.执行SQL语句
			int i = stat.executeUpdate(sql);
			//判断添加语句是否成功
			if(i>0){
				 System.out.println("成功添加:  "+i+"   条数据");
			 } 
			//5.关闭资源 (先开后关)
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

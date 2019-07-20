package com.tz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test3 {

	public static void main(String[] args) {
		//注意：   控制事物的connection必须是同一个
		Connection conn=null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得链接
			String url="jdbc:mysql://localhost:3306/user";
			String user="root";
			String password="123456";
			conn = DriverManager.getConnection(url, user, password);
		//手动开启事务
		conn.setAutoCommit(false);    //将自动设置为手动提交
		 
			//3.获得sql语句平台
			Statement stat = conn.createStatement();
			//编写sql语句
			String sql="update userform set money=money-500 where id=6; ";	 //一条sql语句是一条事务
			
			//4.执行SQL语句
			 stat.executeUpdate(sql);
			//异常
		     int x=1/0;
		//提交事务
		conn.commit();
			/*//int i = stat.executeUpdate(sql);
			//判断添加语句是否成功
			if(i>0){
				 System.out.println("成功添加:  "+i+"   条数据");
			 } */
			//5.关闭资源 (先开后关)
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			try {
				//如果发生了异常 就执行 
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
	}

}

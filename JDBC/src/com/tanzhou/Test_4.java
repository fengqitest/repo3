package com.tanzhou;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tanzhou.JDBCUtils.JDBCUtils;
import com.tanzhou.JDBCUtils.JDBCUtils2;

/*
 * 转账的案例
 * 使用JDBC事物管理
 * 1.开启事物
 * 2.如果没有出现异常就提交事物
 * 3.如果出现了异常我们就回滚
 */
public class Test_4 {
public static void main(String[] args) {
	     
	 Connection conn = null;
	 PreparedStatement pstem = null;
	  
	
	 /*
	  * 
	  * 完成转账
	  * 扣除某个账号的钱
	  * 给另外一个账号加钱
	  */
	 try {
	 //获得连接
	   conn = JDBCUtils2.getconnection();
	   //1.开启事物
	   conn.setAutoCommit(false);
	   //编写SQL语句
		 String sql = "update accuont set  moeny= moeny+? where naam = ?";
		 //预编译
		
			pstem = conn.prepareStatement(sql);
		
		 //设置参数
		 //aaa转账给bbb账号1000
		 pstem.setDouble(1, -1000);
		 pstem.setString(2, "aaa");
		 //执行SQL 扣除aaa账号1000
		 pstem.executeUpdate();
		 
		 int i = 1/0; 
		 //给bbb加1000
		 pstem.setDouble(1, 1000);
		 pstem.setString(2, "bbb");
		 pstem.executeUpdate();
		 //提交事物
		 conn.commit();
		 
	 } catch (SQLException e) {
			//回滚事物
		    try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			//关闭资源
			JDBCUtils2.close(conn, pstem);
		}
	 /*
	  * 在转账中没有添加事物管理，出现了aaa转账的钱被转，没了，但是bbb根本没有收到钱 需要添加事物管理
	  */
}
}

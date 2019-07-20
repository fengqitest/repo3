package com.tanzhou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tanzhou.JDBCUtils.JDBCUtils;

/*
 * jdbc测试类
 */
public class Test_01 {
public static void main(String[] args) throws SQLException {
	      //获得连接
	   Connection  conn =  JDBCUtils.getconnection();
	     //SQL语句
	   String sql = "select sname from sort";
	   //预编译
	   PreparedStatement pst  = conn.prepareStatement(sql);
	   //变量
	    ResultSet rs =  pst.executeQuery();
	    while(rs.next()){
	    	System.out.println(rs.getString("sname"));
	    }
	    //关闭资源
	    JDBCUtils.close(conn, pst, rs);
}
}

package com.stx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
//	private static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private static String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
//	//"jdbc:mysql://localhost:3306/infor?serverTimezone = GMT","root","123456"
//	private static String UNAME = "stx1502";
//	private static String PASSWORD = "orcl";
	/**
	 * 获取连接
	 * @return
	 */
//	public static Connection getConnection(){
//		Connection connection = null;
//		try {
//			//注册驱动
//			Class.forName(DRIVER_CLASS);
//			//获取数据库连接
//			connection = DriverManager.getConnection(URL, UNAME, PASSWORD);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return connection;
//	}
	public static Connection getConnection(){
		Connection con = null;
		if(con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				System.out.println("驱动加载成功");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB?serverTimezone = GMT","root","123456");
				System.out.println("连接数据库成功");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("驱动加载失败");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return con;
	}
	/**
	 * 关闭Connection
	 * @param connection
	 */
	public static void closeConnection(Connection connection){
		try {
			if(connection!=null&&!connection.isClosed()){
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 关闭Statement
	 * @param stmt
	 */
	public static void closeStatement(Statement stmt){
		try {
			if(stmt!=null){
			   stmt.close();//关闭statement
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭ResultSet
	 * @param stmt
	 */
	public static void closeResultSet(ResultSet rs){
		try {
			if(rs!=null){
				rs.close();//关闭statement
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

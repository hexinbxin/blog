package com.stx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.stx.util.DBUtil;


public class TxDemo {

	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		Savepoint savepoint = null;
		try {
			connection.setAutoCommit(false);
			String sql = "insert into students values(?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, 6);
			pstmt.setString(2, "yaya");
			pstmt.setString(3,"男");
			pstmt.setString(4,"yaya@qq.com");
			pstmt.setInt(5, 28);
			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();
			savepoint = connection.setSavepoint();
			sql = "update students set stu_name='stx_stx_stx_stx_stx_'||stu_name where stu_id=6";
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
			connection.commit();//提交事务
		} catch (SQLException e) {
			try {
//				connection.rollback();//回gun事务
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBUtil.closeStatement(pstmt);
			DBUtil.closeConnection(connection);
		}

	}

}

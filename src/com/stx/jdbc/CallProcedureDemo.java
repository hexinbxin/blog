package com.stx.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.stx.util.DBUtil;

public class CallProcedureDemo {

	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = connection.prepareCall("{call p_student_age(?,?)}");
			cstmt.setInt(1, 1);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			System.out.println(cstmt.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeStatement(cstmt);
			DBUtil.closeConnection(connection);
		}
	}

}

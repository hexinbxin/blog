package com.stx.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.stx.util.DBUtil;


public class CallFunctionDemo {

	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt = connection.prepareCall("{?=call f_student_age(?)}");
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, 3);
			cstmt.execute();
			System.out.println(cstmt.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeStatement(cstmt);
			DBUtil.closeConnection(connection);
		}

	}

}

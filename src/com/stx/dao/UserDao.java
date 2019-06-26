package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stx.entity.User;
import com.stx.util.DBUtil;

public class UserDao {

	public User getUser(String uname) {
		Connection connection = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from tbl_user where user_name='" + uname + "'";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int userId = rs.getInt(1);
				int blogId = rs.getInt(2);
				String uName = rs.getString("user_name");
				String userPass = rs.getString("user_pass");
				String userSex = rs.getString("user_sex");
				int userAge = rs.getInt("user_age");
				String userEmail = rs.getString("user_email");
				String userInfo = rs.getString("user_info");
				String userHeader = rs.getString("user_header");
				user = new User(userId, blogId, uName, userPass, userSex, userAge, userEmail, userInfo, userHeader);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(connection);
		}
		return user;
	}
	
	public User getUser(String uname,String password) {
		Connection connection = DBUtil.getConnection();
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from tbl_user where user_name=? and user_pass=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt(1);
				int blogId = rs.getInt(2);
				String uName = rs.getString("user_name");
				String userPass = rs.getString("user_pass");
				String userSex = rs.getString("user_sex");
				int userAge = rs.getInt("user_age");
				String userEmail = rs.getString("user_email");
				String userInfo = rs.getString("user_info");
				String userHeader = rs.getString("user_header");
				user = new User(userId, blogId, uName, userPass, userSex, userAge, userEmail, userInfo, userHeader);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(pstmt);
			DBUtil.closeConnection(connection);
		}
		return user;
	}

	/**
	 * 注册用户
	 * 
	 * @param userName
	 * @return
	 */
	public int registUser(User user) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int result = 0;
		connection = DBUtil.getConnection();
		try {
//			String sql = "insert into tbl_user" + " values(seq_user.nextval," + user.getBlogId() + ",'" + user.getUserName()
//			+ "','" + user.getUserPass() + "','" + user.getUserSex() + "'," + user.getUserAge() + ",'"
//			+ user.getUserEmail() + "','" + user.getUserInfo() + "','" + user.getUserHeader() + "')";
//			String sql = "insert into tbl_user values(seq_user.nextval,?,?,?,?,?,?,?,?)";
//			String sql = "insert into tbl_user values(seq_user.nextval,?,?,?,?,?,?,?,?)";
			String sql = "insert into tbl_user values(default,?,?,?,?,?,?,?,?)";
			// 创建执行sql的对象
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, user.getBlogId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPass());
			pstmt.setString(4, user.getUserSex());
			pstmt.setInt(5, user.getUserAge());
			pstmt.setString(6,user.getUserEmail());
			pstmt.setString(7, user.getUserInfo());
			pstmt.setString(8, user.getUserHeader());
			// 执行sql语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeStatement(pstmt);
			DBUtil.closeConnection(connection);

		}
		return result;
	}

}

package com.stx.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostArticle
 */
public class PostArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String driveName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/DB?serverTimezone = GMT";
		try {
			Class.forName(driveName);
			Connection dbConn=DriverManager.getConnection(url,"root","123456");
			String sql = "insert into PostArticle values(?,?)";
			PreparedStatement statement = dbConn.prepareStatement(sql); //预编译
			String title = request.getParameter("title");
			String cotent = request.getParameter("content");
			
			
			
			statement.setString(1,title);
			statement.setString(2,cotent);
			int rs = statement.executeUpdate();
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(3600);
			response.sendRedirect("success.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

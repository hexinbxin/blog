package ssh;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import jdk.internal.agent.resources.agent;

/**
 * Servlet implementation class Mate
 */
@WebServlet("/Mate")
public class Mate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("adre");
		String love=request.getParameter("like");
		String text=request.getParameter("textarea");
		String table = "history";
		
		
		String driveName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/DB?serverTimezone = GMT";
		  
		  try {
			Class.forName(driveName);
			Connection dbConn=DriverManager.getConnection(url,"root","123456");
			System.out.println("连接数据库成功");
		      String sql="insert into"+ " "+table+" "+ "values(?,?,?,?,?,?,?)";
		      PreparedStatement pstmt=dbConn.prepareStatement(sql);
		        pstmt.setString(1, name);
				pstmt.setString(2,age);
				pstmt.setString(3, phone);
				pstmt.setString(4,email);
				pstmt.setString(5,love);
				pstmt.setString(6,address);
				pstmt.setString(7,text);
				
				int i = pstmt.executeUpdate();
				   if (i >= 0) {
				    System.out.println("保存成功...");
				    @SuppressWarnings("unused")
					HttpSession session=request.getSession();
				    response.sendRedirect("user/main.jsp");
				    
				   }
				   else {
					   System.out.println("保存失败");
				   }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
		//doGet(request, response);
	}



package ssh;

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
 * Servlet implementation class Select
 */
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String driveName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/DB?serverTimezone = GMT";
		
	    try {
			Class.forName(driveName);
			Connection dbConn=DriverManager.getConnection(url,"root","123456");
			
//			String sql="select * from tbl_user where user_name=? and user_pass=?";
			//PreparedStatement pstmt=dbConn.prepareStatement(sql);
			//ResultSet rs1= pstmt.executeQuery();
//			if(rs1.next()){
//				System.out.println("成功");
				String sql1="select * from history";
				System.out.println("断电");
				PreparedStatement ps= null;
				ResultSet rs=null;
				ps = dbConn.prepareStatement(sql1);
				rs = ps.executeQuery();
				
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(3600);
				session.setAttribute("rs", rs);
				//session.setAttribute("username", username);
				response.sendRedirect("select.jsp");
				
				//}
//			else {
//				System.out.println("失败");
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

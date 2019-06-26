package com.stx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String method = request.getParameter("method");
		String userId = request.getParameter("userId");
		String love = request.getParameter("love");
		String[] loves = request.getParameterValues("love");
		
		request.setAttribute("USERNAME", uname);
		
		String username = (String)request.getAttribute("USERNAME");
		
		PrintWriter out = response.getWriter();
		out.print("user:"+uname+"<br/>"+"passwrod:"+upass+"<br/>");
		out.println("method:"+method+"<br/>userId:"+userId);
		for(String s : loves){
			out.println("love"+s+",");
		}
		out.println("<br/>love:"+love);
		out.println("<br/>username:"+username);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String company = config.getInitParameter("company");
		System.out.println(company);

		// ȡȫ�ֲ���
		String school = config.getServletContext().getInitParameter("school");
		System.out.println(school);
	}

}

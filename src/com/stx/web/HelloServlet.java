package com.stx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        System.out.println("调用了构造方法");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用了服务方法");
		//设置响应对象文档格式及字符编码
//		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("gb2312");
		//得到输出流
		PrintWriter out = response.getWriter();
		out.print("Hello World!");//输出内容
		out.write("<font color='red'>你好，世界</font>");
//		String s = null;
//	    System.out.println(s.toString());
		HttpSession session = request.getSession();
//		session.invalidate();//销毁session
		String uname = (String)session.getAttribute("USERNAME");
		int time = session.getMaxInactiveInterval();
		if(uname==null){
			response.sendRedirect("login.html");
		}else{
			response.sendRedirect("index.html");
		}
		out.print(uname+"欢迎访问"+"session默认时长："+time);
		out.flush();//清空缓存
		out.close();//关闭流
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("调用了初始化方法");
		String company = config.getInitParameter("company");
		System.out.println("初始参数为："+company);
		//取全局参数
		String school = config.getServletContext().getInitParameter("school");
		System.out.println(school);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("调用了销毁方法");
	}
	
	
	
	

}

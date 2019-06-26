package com.stx.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.dao.UserDao;
import com.stx.entity.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");
		if("login".equals(op)){
			doLogin(request,response);
		}
		if("reg".equals(op)){
			doRegister(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//request.setCharacterEncoding("UTF-8");//只针对post提交
		//response.setCharacterEncoding("UTF-8");
		String uname = request.getParameter("uname");
		//uname = new String(uname.getBytes("ISO-8859-1"),"gb2312");//get提交中文转码
		String upass = request.getParameter("pwd");
		System.out.println(uname+"$$"+upass);
		//创建session,无参getSession()方法，如果session存在，返回当前session对象，如果不存在返回新的session对象
		//HttpSession session = request.getSession();
		//创建session,无参getSession(false)方法，如果session存在，返回当前session对象，如果不存在返回null
		HttpSession session = request.getSession();
//		User user = userDao.getUser(uname);
		User user = userDao.getUser(uname,upass);
		if(user!=null){
			session.setAttribute("USER", user);
			//response.sendRedirect("user/ArticleServlet?op=list");
			response.sendRedirect("user/main.jsp");
		}else{
			request.setAttribute("MSG", "登录失败");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
//		if("admin".equals(uname)&&"123456".equals(upass)){
////			request.setAttribute("USERNAME", uname);
//			session.setAttribute("USERNAME", uname);
////			request.getRequestDispatcher("hello").forward(request, response);
//			response.sendRedirect("hello");
//		}else{
////			request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
//			response.sendRedirect("login.html");
//		}
	}
	
	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//request.setCharacterEncoding("UTF-8");
		//获取表单数据
		String uname = request.getParameter("uname");
		String upass = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		String fileName = request.getParameter("fileName");
		
		//封装用户数据 User user = new User(); user.setUserName(username);
		User user = new User(0,0,uname,upass,sex,0,email,content,fileName);
		//调用userDao注册方法registUser()
		int result = userDao.registUser(user);
		//通过返回的整数实现不同跳转，如果返回大于 0整数，跳转到登陆页面，否则跳到错误页面
		if(result>0){
			request.setAttribute("MSG", "注册成功");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			request.setAttribute("MSG", "注册失败");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}

package com.stx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stx.dao.ArticleDao;
import com.stx.entity.Article;
import com.stx.entity.Blog;
import com.stx.entity.Category;
import com.stx.entity.User;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao articleDao = new ArticleDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("list".equals(op)) {
			listArticle(request, response);
		}
		if ("insert".equals(op)) {
			addArticle(request, response);
		}
		if("delete".equals(op)){
			delArticle(request,response);
		}
		if("get".equals(op)){
			getArticle(request,response);
		}
		if("update".equals(op)){
			updateArticle(request,response);
		}
		if("all".equals(op)){
			listAllArticle(request,response);
		}
	}

	private void updateArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String articleId = request.getParameter("aid");
		int aid = 0;
		if(articleId!=null){
			aid = Integer.parseInt(articleId);
		}
		
		String cateId = request.getParameter("cate");
		int catgoryId = 0;
		if (cateId != null) {
			catgoryId = Integer.parseInt(cateId);
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 取出session中的用户信息，其中包含博客ID
		User user = (User) request.getSession().getAttribute("USER");
		Blog blog = new Blog();
		blog.setBlogId(user.getBlogId());
		Category category = new Category();
		category.setCategoryId(catgoryId);
		Article article = new Article(aid, blog, category, title, content, null);

		int result = articleDao.updateArticle(article);

		if (result > 0) {
			response.sendRedirect("ArticleServlet?op=list");
		} else {
			response.sendRedirect("blog_update.jsp");
		}
	}

	private void getArticle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String articleId = request.getParameter("aid");
		int aid = 0;
		if(articleId!=null){
			aid = Integer.parseInt(articleId);
		}
		Article article = articleDao.getArticle(aid);
		
		if(article!=null){
			request.setAttribute("ARTICLE", article);
			request.getRequestDispatcher("blog_update.jsp").forward(request, response);
		}
	}

	private void delArticle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String articleId = request.getParameter("aid");
		int aid = 0;
		if(articleId!=null){
			aid = Integer.parseInt(articleId);
		}
		
		int result = articleDao.deleteArticle(aid);
		
        if(result>0){
        	response.sendRedirect("ArticleServlet?op=list&page=manager");
        }else{
        	response.sendRedirect("ArticleServlet?op=list&page=manager");
        }		
	}

	
	private void addArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cateId = request.getParameter("cate");
		int catgoryId = 0;
		if (cateId != null) {
			catgoryId = Integer.parseInt(cateId);
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 取出session中的用户信息，其中包含博客ID
		User user = (User) request.getSession().getAttribute("USER");
		Blog blog = new Blog();
		blog.setBlogId(user.getBlogId());
		Category category = new Category();
		category.setCategoryId(catgoryId);
		Article article = new Article(0, blog, category, title, content, null);

		int result = articleDao.addArticle(article);

		if (result > 0) {
			response.sendRedirect("ArticleServlet?op=list");
		} else {
			response.sendRedirect("blog_add.jsp");
		}

	}

	private void listArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");

		List<Article> articles = articleDao.searchArticle(user.getBlogId(),false);
		
		if (articles != null && articles.size() > 0) {
			request.setAttribute("ARTICLES", articles);
			if (page != null && "manager".equals(page)) {
				request.getRequestDispatcher("blog_manager.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		}

	}
	
	private void listAllArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		PrintWriter out = response.getWriter();
		
		List<Article> articles = null;
		articles = articleDao.searchArticle(user.getBlogId(),true);
		
		if (articles != null && articles.size() > 0) {
			request.setAttribute("ARTICLES", articles);
			ObjectMapper mapper = new ObjectMapper();
			String strArticle=mapper.writeValueAsString(articles);
			out.print(strArticle);
			out.flush();
			out.close();
			}
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

}

package com.stx.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stx.entity.Article;
import com.stx.entity.Blog;
import com.stx.entity.Category;
import com.stx.util.DBUtil;

public class ArticleDao {
	/**
	 * 查询登陆用户发表的博文
	 * 
	 * @param blogId
	 * @return
	 */
	public List<Article> searchArticle(int blogId,boolean all) {
		List<Article> articles = new ArrayList<Article>();
		Connection connection = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(all)
			  sql = "select * from tbl_article where blog_id=" + blogId + " order by article_time desc";
			else
				sql = "select * from tbl_article where blog_id=" + blogId + " and rownum<=2 order by article_time desc";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int articleId = rs.getInt("article_id");
				int bid = rs.getInt("blog_id");
				int categoryId = rs.getInt("category_id");
				String articleTitle = rs.getString("article_title");
				String articleContent = rs.getString("article_content");
				Date articleTime = rs.getDate("article_time");
				Article article = new Article();
				article.setArticleId(articleId);

				Blog blog = new Blog();
				blog.setBlogId(bid);
				article.setBlog(blog);

				Category category = new Category();
				category.setCategoryId(categoryId);
				article.setCategory(category);

				article.setArticleTitle(articleTitle);
				article.setArticleContent(articleContent);
				article.setArticleTime(articleTime);

				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(connection);
		}
		return articles;
	}

	public int addArticle(Article article) {
		int result = 0;
		Connection connection = DBUtil.getConnection();
		Statement stmt = null;
		try {
			String sql = "insert into tbl_article values(seq_article.nextval," + article.getBlog().getBlogId() + ","
					+ article.getCategory().getCategoryId() + ",'" + article.getArticleTitle() + "','"
					+ article.getArticleContent() + "',sysdate)";
			stmt = connection.createStatement();
			result =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(connection);
		}
		return result;
	}
	
	public int deleteArticle(int articleId) {
		int result = 0;
		Connection connection = DBUtil.getConnection();
		Statement stmt = null;
		try {
			String sql = "delete from tbl_article where article_Id="+articleId;
			stmt = connection.createStatement();
			result =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(connection);
		}
		return result;
	}
	
	
	public Article getArticle(int articleId){
		Article article = null;
		Connection connection = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select a.*,c.* from tbl_article a ,tbl_category c where a.category_id=c.category_id and article_id="+articleId;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int aId = rs.getInt("article_id");
				int bid = rs.getInt("blog_id");
				int categoryId = rs.getInt("category_id");
				String categoryTitle = rs.getString("category_title");
				String articleTitle = rs.getString("article_title");
				String articleContent = rs.getString("article_content");
				Date articleTime = rs.getDate("article_time");
				article = new Article();
				article.setArticleId(aId);

				Blog blog = new Blog();
				blog.setBlogId(bid);
				article.setBlog(blog);

				Category category = new Category();
				category.setCategoryId(categoryId);
				category.setCategoryTitle(categoryTitle);
				article.setCategory(category);

				article.setArticleTitle(articleTitle);
				article.setArticleContent(articleContent);
				article.setArticleTime(articleTime);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(connection);
		}
		return article;
	}
	
	
	public int updateArticle(Article article) {
		int result = 0;
		Connection connection = DBUtil.getConnection();
		Statement stmt = null;
		try {
			String sql = "update tbl_article set category_id=" + article.getCategory().getCategoryId()
					+ ",article_title='" + article.getArticleTitle() + "',article_content='"
					+ article.getArticleContent() + "' where article_id="+article.getArticleId();
			stmt = connection.createStatement();
			result =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(connection);
		}
		return result;
	}

}

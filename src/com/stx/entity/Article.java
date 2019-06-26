package com.stx.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int articleId;
	private Blog blog;
	private Category category;
	private String articleTitle;
	private String articleContent;
	private Date articleTime;
	
	public Article() {
		super();
	}
	public Article(int articleId, Blog blog, Category category, String articleTitle, String articleContent,
			Date articleTime) {
		super();
		this.articleId = articleId;
		this.blog = blog;
		this.category = category;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleTime = articleTime;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public Date getArticleTime() {
		return articleTime;
	}
	public void setArticleTime(Date articleTime) {
		this.articleTime = articleTime;
	}
	
	

}

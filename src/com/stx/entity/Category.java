package com.stx.entity;

public class Category {
	private int categoryId;
	private Blog blog;
	private String categoryTitle;
	
	public Category() {
		super();
	}
	public Category(int categoryId, Blog blog, String categoryTitle) {
		super();
		this.categoryId = categoryId;
		this.blog = blog;
		this.categoryTitle = categoryTitle;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	

}

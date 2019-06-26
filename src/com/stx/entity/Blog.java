package com.stx.entity;

public class Blog {
	private int blogId;
	private String blogTitle;
	private String blogLogo;
	
	public Blog() {
		super();
	}

	public Blog(int blogId, String blogTitle, String blogLogo) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogLogo = blogLogo;
	}
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogLogo() {
		return blogLogo;
	}
	public void setBlogLogo(String blogLogo) {
		this.blogLogo = blogLogo;
	}
	
	

}

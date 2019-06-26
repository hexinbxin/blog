package com.stx.entity;

public class User {
	private int userId;
	private int blogId;
	private String userName;
	private String userPass;
	private String userSex;
	private int userAge;
	private String userEmail;
	private String userInfo;
	private String userHeader;
	
	public User() {
		super();
	}
	public User(int userId, int blogId, String userName, String userPass, String userSex, int userAge, String userEmail,
			String userInfo, String userHeader) {
		super();
		this.userId = userId;
		this.blogId = blogId;
		this.userName = userName;
		this.userPass = userPass;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userInfo = userInfo;
		this.userHeader = userHeader;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getUserHeader() {
		return userHeader;
	}
	public void setUserHeader(String userHeader) {
		this.userHeader = userHeader;
	}
	
	

}

<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.stx.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
欢迎
<%
User user = (User)session.getAttribute("USER");
//out.println("欢迎"+user.getUserName()+"登录成功！");
%>
<%=user.getUserName() %>
登录成功!
</body>
</html>
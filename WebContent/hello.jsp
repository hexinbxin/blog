<?xml version="1.0" encoding="UTF-8" ?>
<%-- <%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%> --%>
<%@ page language="java" import="java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<!-- html注释<%=1+1 %> -->
<%-- jsp注释<%=1+1 %> --%>
<%
//out.println("Hello World!!!!!");
int num1=10;
int num2 = 20;
%>

<%=1+1 %>
<%//=out.println("hello world") %>
<%//="hello world!" %>
<%=num1+num2 %>
<%=n1+n2%>
<%//=add(num1,num2) %>
<%!
int n1=50;
int n2 = 100;
/*int add(int n1, int n2){
	return n1+n2;
}*/
%>

<%
Date sysDate = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
out.println(df.format(sysDate));
String s=null;
s.toString();
%>
</body>
</html>
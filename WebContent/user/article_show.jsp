<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  ResultSet rs=(ResultSet) session.getAttribute("rs");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="../css/base.css"/>
<style>
   table{
   border:1px solid black;
   }
   td{
   }
</style>
</head>
<body>
<table class="table table-hover">
  <caption></caption>
  <thead>
    <tr>
      <th>标题</th>
      <th>内容</th>
    </tr>
  </thead>
  <tbody>
  <%while(rs.next()) {
	  %>
	<tr>
	    <td><%=rs.getString("title")%></td>
	    <td><%=rs.getString("content")%></td>

	  
	</tr>  
	  
	<%} %>
  
    
  </tbody>
</table>
</body>
</html>
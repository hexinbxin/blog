<%@page import="java.sql.ResultSet" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  ResultSet rs=(ResultSet) session.getAttribute("rs");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="../css/select.css">
</head>
<body>
<%-- <%
 String name=(String)session.getAttribute("username");
%> --%>
<%-- <h1 class="name"><%=name%>,欢迎使用!给您留言的信息都展示在了下方</h1> --%>

<table class="table table-hover">
  <caption></caption>
  <thead>
    <tr>
      <th>用户名</th>
      <th>年龄</th>
      <th>电话号码</th>
      <th>email</th>
      <th>爱好</th>
      <th>地址</th>
      <th>留言</th>
    </tr>
  </thead>
  <tbody>
  <%while(rs.next()) {
	  %>
	<tr>
	    <td><%=rs.getString("name")%></td>
	    <td><%=rs.getString("age")%></td>
	    <td><%=rs.getString("phone")%></td>
	    <td><%=rs.getString("email")%></td>
	    <td><%=rs.getString("love")%></td>
	    <td><%=rs.getString("address")%></td>
	    <td><%=rs.getString("text")%></td>
	   <%--  <td><a href="Delete?id=<%=rs.getInt("id")%>>" onClick="return confirm('是否确定');">删除</a></td>
	    <td><a href="Update?id=<%=rs.getInt("id")%>" onClick="return confirm('是否确定');">修改</a></td> --%>
	  
	</tr>  
	  
	<%} %>
  
    
  </tbody>
</table>



</body>
</html>
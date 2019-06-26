<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script>
	var time = 5;
	function gotoLogin(){
		time--;
		var alertMsg = document.getElementById("alterMsg");
		if(time>=0){
		alertMsg.innerHTML = "<font color='red'>"+time+"</font>秒之后返回登录页面！";
		}else{
			window.location.href = "login.jsp";
		}
		window.setTimeout("gotoLogin()",1000);
	}
</script>
</head>
<body onload="gotoLogin()">
<%
String msg = (String)request.getAttribute("MSG");
%>
<%=msg %>
<span id="alterMsg">5秒之后返回登录页面！</span>
</body>
</html>
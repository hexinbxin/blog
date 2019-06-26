<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录页面</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function check(){
	var uname = document.getElementById("uname").value;
	if(uname==""){
	   alert("用户名不能为空！");
	   return false;
	}

	var password = document.myform.pwd;
	if(password.value.length<3){
		alert("密码必须是3位以上");
		password.focus();
	    password.select();
		return false;
		}
		document.myform.submit();//提交表单
	return true;
}
</script>
</head>

<body>
<div id="header" class="main">
  <div id="headerLeft"><img src="images/logo.jpg" height="50"/></div>
  <div id="headerRight"><a href="./register.jsp">注册</a> | 登录 | 帮助[<a href="mate.jsp">留言</a>]</div>
</div>
<div  class="main">
<table id="center" border="0" cellspacing="0" cellpadding="0">
    <td class="bg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
    <td class="bold">个人博客</td>
  </tr>
  <form action="UserServlet" method="post" name="myform" onsubmit="return check()"><tr>
    <input name="op" value="login" type="hidden" />
    <td>用户名：<input id="uname" name="uname" type="text"  class="inputs"/></td>
  </tr>
  <tr>
    <td>&nbsp;密  码：<input id="pwd" name="pwd" type="password"   class="inputs"/></td>
  </tr>
  <tr>
    <td style="height:35px; padding-left:30px;"><input name="btn" type="button" value="登录" class="rb1" onclick="check()"/></td>
  </tr></form>
</table>
</td>
  </tr>
</table>
</div>
</body>
</html>

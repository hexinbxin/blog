<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script type="text/javascript" src="mate/check.js"></script>
<link href="css/register.css" rel="stylesheet" type="text/css">
<title>用户注册</title>
</head>

<body>
<center>

<form name="myform" action="<%=request.getContextPath()%>/UploadServlet" method="post" enctype="multipart/form-data">
<input name="op" value="reg" type="hidden" />
<table id="tab" border="0">
<caption align="top"><h1>填写用户信息</h1></caption>
<tr>
  <td align="right">用户名：*</td>
  <td><input id="uname" name="uname" type="text"  class="inputs" onblur="checkMName(this.value)" required/> <span id="msg"></span></td>
</tr>
<tr>
  <td align="right">密码：*</td>
  <td><input id="pwd" name="pwd" type="password"   class="inputs" required/></td>
</tr>
<tr>
  <td align="right">确认密码：*</td>
  <td><input id="repwd" name="repwd" type="password"   class="inputs" required/></td>
</tr>
<tr>
  <td align="right">性别：*</td>
  <td><input type="radio" name="sex" value="男"/>男 <input type="radio" name="sex" value="女"/>女</td>
</tr>
<tr>
  <td align="right">邮件地址：</td>
  <td><input id="email" name="email" type="text"  class="inputs" size="50"/></td>
</tr>
<tr>
  <td align="right">基本情况：</td>
  <td><textarea cols="50" rows="10" name="content"></textarea></td>
</tr>
<tr>
  <td height="31" align="right">个人照片：</td>
  <td><input id="file" name="file" type="file" size="50" required/>(请选择个人照片.jpg)</td>
</tr>
<tr>
  <td colspan="2" align="center">
  <input name="btn" type="submit" value="注册" class="rb1" onclick="check()"/>
  <input name="btn" type="button" value="取消" class="rb1" onclick="window.history.back();"/>
  </td>
</tr>
</table>
</form>
</center>
</body>
</html>

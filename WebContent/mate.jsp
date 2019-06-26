<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户留言界面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="css/mate.css"/>
<script type="text/javascript" src="mate/check.js"></script>
</head>
<body>
<h1 class="wel">欢迎使用</h1>

<!-- <ul class="nav nav-pills nav-stacked">
  <li class="active"><a href="Rigister.jsp">点击也去注册一个账户，让其他人为你留言</a></li>
</ul> -->
<br>
<br>
<form class="form-horizontal" role="form" action="Mate" method="get">

<!-- <div class="form-group">
    <label class="col-sm-2 control-label" for="matename"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>邀请您的用户</label>
    <span id="msg"></span>
    <div class="col-sm-2">
      <input type="text" class="form-control" placeholder="在这里输入邀请你的用户的名字来给他留言" name="matename" id="matename" onblur="checkMName(this.value)"/>
    </div>
  </div> -->
  
<div class="form-group">
    <label class="col-sm-2 control-label" for="name">姓名</label>
    <div class="col-sm-5">
      <input type="text" class="form-control"placeholder="请输入你的名字" name="name" id="name">
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label" for="age">年龄</label>
    <div class="col-sm-5">
      <input type="text" class="form-control"placeholder="请输入年龄" name="age" id="age"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label" for="phone">电话号码</label>
    <div class="col-sm-2">
      <input type="text" class="form-control"placeholder="请输入你的电话号码" name="phone" id="phone"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label" for="email">Email</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" placeholder="请输入你的电子邮箱" name="email" id="email"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label" for="like">爱好</label>
    <div class="col-sm-2">
      <input type="text" class="form-control"placeholder="请输入你的爱好" name="like" id="like"/>
    </div>
  </div>

  
  <div class="form-group">
    <label class="col-sm-2 control-label" for="adre">地址</label>
    <div class="col-sm-2">
      <input type="text" class="form-control"placeholder="请输入你的地址" name="adre" id="adre"/>
    </div>
  </div>
  
  
  
  <div class="form-group">
  <label class="col-sm-2 control-label">写下你的意见</label>
  <div class="col-sm-5">
  <textarea class="form-control" rows="3" name=textarea></textarea>  
  </div>
  </div>
    <div class="sub"><button type="button" class="btn btn-info" onclick ="form.submit()" >提交</button></div>

</form>
</body>
</html>
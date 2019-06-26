<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jspf" %>
  <div id="main">
      <h1>
        发表博文</font>
      </h1>
    <form action="../PostArticle" method="post" name="myform">
    <INPUT type="hidden" name="op" value="insert" />
      <table id="tbl">
      <tr>
        <td align="right">分类:</td>
        <td>
          <select name="cate">
             <option value="1">计算机</option>
             <option value="2">体育</option>
             <option value="3">音乐</option>
          </select>
        </td>
      </tr>
      <tr>
        <td align="right">标题:</td>
        <td>
        <input type="text" name="title" size="50" />
        </td>
      </tr>
      <tr>
      <td>内容</td>
        <td>
        <textarea name="content" cols="100" rows="16">
        </textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
        <input type="submit" value="发表" />
        <input type="reset" value="取消" />
        </td>
      </tr>
      </table>
      </form>  
  </div>
  <%@ include file="footer.jspf" %>
</body>
</html>

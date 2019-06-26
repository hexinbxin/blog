<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.stx.entity.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jspf" %>
<%
Article article = (Article)request.getAttribute("ARTICLE");
if(article!=null){

%>
  <div id="main">
      <h1>
        更新博文</font>
      </h1>
    <FORM action="<%=request.getContextPath()%>/user/ArticleServlet" method="post" name="myform">
    <INPUT type="hidden" name="aid" value="<%=article.getArticleId() %>" />
    <INPUT type="hidden" name="op" value="update" />
      <table id="tbl">
      <tr>
        <td align="right">分类:</td>
        <td>
          <select name="cate">
             <option value="<%=article.getCategory().getCategoryId()%>" selected="selected"><%=article.getCategory().getCategoryTitle()%></option>
             <option value="1">计算机</option>
             <option value="2">体育</option>
             <option value="3">音乐</option>
          </select>
        </td>
      </tr>
      <tr>
        <td align="right">标题:</td>
        <td>
        <input type="text" name="title" size="50" value="<%=article.getArticleTitle()%>"/>
        </td>
      </tr>
      <tr>
      <td>内容</td>
        <td>
        <textarea name="content" cols="100" rows="16">
         <%=article.getArticleContent()%>
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
      </FORM>  
  </div>
  <%
}else{
	out.println("博文不存在！");
}
  %>
  <%@ include file="footer.jspf" %>
</body>
</html>

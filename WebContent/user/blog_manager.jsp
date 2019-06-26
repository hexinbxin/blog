<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.stx.entity.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jspf" %>
<script type="text/javascript">
<!--
function delMsg(aid){
	if(window.confirm("是否要删除？")){
		alert(aid);
		window.location.href='ArticleServlet?op=delete&aid='+aid;
	}
}
//-->
</script>
  <div id="main">
      <h1>
        博文列表</font>
      </h1>
    <table border="0" width="98%">
    <%
    List<Article> articles = (List<Article>)request.getAttribute("ARTICLES");
    if(articles!=null&&articles.size()>0){
    	for(int i=0;i<articles.size();i++){
    		Article article = articles.get(i);
    	
    
    %>
      <tr>
        <td height="20"><img src="../images/dot.jpg" /></td>
        <td><%=article.getArticleTitle() %></td>
        <td align="center"><%=article.getArticleTime() %></td>
        <td align="center">[<a href="ArticleServlet?op=get&aid=<%=article.getArticleId()%>">编辑</a>][<a href="javascript:delMsg(<%=article.getArticleId()%>)">删除</a>]</td>
      </tr>
     <%
    	}
    }
     %>  
      <tr>
         <td colspan="4" height="20">
         页次：1/1 20/页 共2条 分页：<a href="#">首页</a> <a href="#">上页</a> <a href="#">下页</a> <a href="#">尾页</a> <a href="#">发文</a> <a href="#">分类管理</a>
         </td>
      </tr>
      </table>
     
  </div>
   <%@ include file="footer.jspf" %>
</body>
</html>

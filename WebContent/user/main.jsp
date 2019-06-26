<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.stx.entity.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jspf" %>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#all").click(function(){
			$.ajax({
				type:"get",
				url:"ArticleServlet",
				async:true,
		        data:"op=all",
		        success:function(data){
		        	var article = eval("("+data+")");
		        	alert(article[0].articleTitle);
		        	for(var i=3;i<data.length;i++){
		        		
		        	}
		        }
			});
		});
	});
</script>
		<div id="main">
			<%
  List<Article> articles = (List<Article>)request.getAttribute("ARTICLES");
  if(articles!=null&&articles.size()>0){
	  for(int i=0;i<articles.size();i++){
		  Article article = articles.get(i); 
  
  %>
			<h1>
				<%=article.getArticleTitle() %> &nbsp;&nbsp;&nbsp;&nbsp;<font size="-1"><%=article.getArticleTime() %></font>
			</h1>
			<div class="content">
				&nbsp;&nbsp;&nbsp;&nbsp;<%=article.getArticleContent() %>
				<div class="line">
					<div class="read">
						<a href="#">阅读</a>(2)&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">评论</a>(0)
					</div>
					<div class="all">
						<a href="blogcontent.html">查看全文>></a>
					</div>
				</div>
			</div>
	<% 
	    }
      }
      %>
      <div id="page">
				<div id="all">阅读更多</div>
	 </div>
	<%@ include file="footer.jspf" %>		
			
</body>
</html>

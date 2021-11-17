<%@page import="java.util.List"%>
<%@page import="blog.models.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Les articles</h1>
<ul>
	<% for (Article post : (List<Article>) request.getAttribute("posts")) { %>
		<li>	
			<a href="/blog/post?title=<%= post.getTitle() %>"><%= post.getTitle() %></a>
		</li>
	<% } %>
</ul>
</body>
</html>
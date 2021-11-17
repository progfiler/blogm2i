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
	<% Article post = (Article) request.getAttribute("post"); %>
	<h1><%= post.getTitle() %></h1>
	<p>
		<%= post.getContent() %>
	</p>
	<p>
	Crée par : <b><%= post.getUser().getUsername() %></b>
	</p>
</body>
</html>
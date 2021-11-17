<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Mon profil</h1>
	<ul>
		<li>
			Nom d'utilisateur : <b>${user.getUsername()}</b>
		</li>
		<li>
			Email : <b>${user.getEmail()}</b>
		</li>
		<li>
			Nombre d'articles : <b>${user.getNbrPost()}</b>
		</li>
		<li>
			Rôle : <b>${user.getRole()}</b>
		</li>
	</ul>
</body>
</html>
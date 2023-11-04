<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center">Welcome to login Page!</h1>
		<span style="text-align: center"> ${errorMessage} </span>
		<form method="post">
		Name: <input type="text" name="name">
		Password: <input type="password" name="password">
		<input type="submit">
		</form>
	</div>
</body>
</html>
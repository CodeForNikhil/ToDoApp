<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
<title>Welcome</title>
</head>
<body>
	<%@ include file="common/Navigation.jspf"%>
	<div class="container">
		<h1 style="text-align: center">
			Welcome to the page ${name} <br>
		</h1>
		<div style="text-align: center">
			<h2>
				<a href="list-todo">Manage</a> your To Do's
			</h2>
		</div>
	</div>
</body>
</html>
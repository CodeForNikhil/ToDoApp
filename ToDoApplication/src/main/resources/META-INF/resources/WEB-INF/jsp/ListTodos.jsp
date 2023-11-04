<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<title>List Todo Page</title>
</head>
<body>
	<script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<%@ include file="common/Navigation.jspf" %>
	<div class="container">
	<h1 style="text-align: center">Welcome to List of ToDo's page
		${name}</h1>
	<hr>
	<table class="table">
		<br>
		<thead>
			<th>Description</th>
			<th>Target Date</th>
			<th>Is Completed?</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${todo}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.date}</td>
					<td>${todo.done}</td>
					<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add To Do</a>
</div>
</body>
</html>
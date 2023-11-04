<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
<title>Add Todo Page</title>
</head>
<body>
	<script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<%@ include file="common/Navigation.jspf" %>
	<div class="container">
		<h1 style="text-align: center">To Do Details</h1>
		<hr>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description"> Description: </form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" />
			</fieldset>
			<fieldset class="mb-3">
				<form:label path="date"> Date: </form:label>
				<form:input type="text" path="date" required="required" />
				<form:errors path="date" />
			</fieldset>
			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<input type="submit" class="btn btn-success">
		</form:form>
		<script type="text/javascript">
		$('#date').datepicker({
		    format: 'yyyy-mm-dd'
		});
		</script>
	</div>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topekox Company Home Page</title>
</head>
<body>

	<h1>Topekox Home Page</h1>
	<hr />
	<p>Welcome to the Topekox Home Page. Yohooo!!!!</p>

	<!-- add logout -->
	<hr />
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>

</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	
	<hr />
	<!-- display username & roles -->
	User : <security:authentication property="principal.username"/>
	<br /><br />
	Roles : <security:authentication property="principal.authorities"/>

	<!-- add logout -->
	<hr />
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>

</body>
</html>
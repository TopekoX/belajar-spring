<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
	<p>
		User :
		<security:authentication property="principal.username" />
		<br /> <br /> Roles :
		<security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add link to point to /leaders ... this is for the manager -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a> (Only for manager)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!-- Add link to point to /systems ... this is for the admin -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System
				meeting</a> (Only for admin)
		</p>
	</security:authorize>

	<!-- add logout -->
	<hr />
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relation Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<c:forEach var="c" items="${customer}">
					<tr>
						<td>${c.firstName}</td>
						<td>${c.lastName}</td>
						<td>${c.email}</td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<title>Login Page</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	rel="stylesheet" crossorigin="anonymous" />
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>

	<div class="container">
		<div class="wrapper">
			<div class="logo">
				<img
					src="https://www.freepnglogos.com/uploads/apex-legends-logo-png/apex-game-png-logo-21.png"
					alt="Apex Legends">
			</div>
			<div class="text-center mt-4 name">Login</div>

			<c:if test="${param.error != null}">
				<br />
				<div class="alert alert-danger" role="alert">Sorry!!! Username
					or Password Invalid!</div>
			</c:if>

			<c:if test="${param.logout != null}">
				<br />
				<div class="alert alert-success" role="alert">You have been Logout!</div>
			</c:if>

			<form
				action="${pageContext.request.contextPath}/authenticateUser"
				method="POST" class="p-3 mt-3">
				<div class="form-field d-flex align-items-center">
					<span class="far fa-user"></span> <input type="text"
						name="username" id="userName" placeholder="Username">
				</div>
				<div class="form-field d-flex align-items-center">
					<span class="fas fa-key"></span> <input type="password"
						name="password" id="pwd" placeholder="Password">
				</div>				
				<button type="submit" class="btn mt-3">Login</button>
				
				<!-- manually CSRF token Bro... -->
				<input type="hidden"
					name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				
			</form>
			
		</div>
	</div>

</body>
</html>
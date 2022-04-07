<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Costumer Confirmation</title>
</head>
<body>

	The Costumer is confirmed : ${costumer.firstName} ${costumer.lastName}
	
	<br> <br>
	
	Tiket Gratis : ${costumer.tiketGratis}

</body>
</html>
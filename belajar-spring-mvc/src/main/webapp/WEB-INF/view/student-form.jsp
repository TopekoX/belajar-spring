<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		
		First name : <form:input path="firstName"/>
		
		<br><br>
		
		Last name : <form:input path="lastName"/>
		
		<br><br>
		
		Country:
		
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select> 
		
		<br><br>
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		
		<br><br>
		
		<input type="submit" value="submit"/>
		
	</form:form>

</body>
</html>
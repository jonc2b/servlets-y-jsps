<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1> Login - Tienda Online </h1>

<c:if test="${ not empty requestScope.error }">

	<hr>${ requestScope.error }</hr>
</c:if>
<form action="loginServlet" method="post">
	<label for="name">Nombre</label>
	<input type="text" name="paramName" id="name"/>
	<br/>
	<label for="password">Clave</label>
	<input type="password" name="paramPwd" id="password"/>
	
	<input type="submit" value="login"/>
</form>	
</body>
</html>
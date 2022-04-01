<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Bienvenida</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${saludo} </h1>
				<p> ${linea1} </p>
			</div>
		</div>
	</section>
	<a href="<c:url value ="/productos"/>"class="btn btn-primary btn-lg"role="button" >
	<spring:message code="producto.btn.lista" /></a>
	<a href="<c:url value ="/productos/nuevo"/>"class="btn btn-primary btn-lg"role="button" >
	<spring:message code="producto.btn.nuevo" /></a>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  

<html> 
    <title>Pedido error</title> 
    <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

</head> 
<body> 
    <section> 
        <div class="jumbotron"> 
            <div class="container"> 
                <h1 class="alert alert-danger"> 
                    
                  ${mensaje} 
                    
                </h1> 
            </div> 
        </div> 
    </section> 

    <section> 
        <div class="container"> 
            <p>${url}</p> 
            <p>${exception}</p> 
        </div> 

        <div class="container"> 
            <p> 
                <a href="<spring:url value="/productos" />" 
                   class="btn btn-primary"> 
                    <span class="glyphicon-hand-left glyphicon">
                    </span> productos 
                </a> 
            </p> 
        </div> 

    </section> 
</body> 
</html>
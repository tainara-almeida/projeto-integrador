<%-- 
    Document   : acessoNegado
    Created on : 27/11/2021, 12:00:59
    Author     : Andrew
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="SenacToys/uteis/header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <nav class="container menu">
                   
                    <div>
                        <p></p>
                    </div>
                    
                    <ul>
                        <img src="SenacToys/uteis/pica.jpg">
                        <li><a href="${pageContext.request.contextPath}/SenacToys/index.jsp">Voltar à Home</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </body>
</html>

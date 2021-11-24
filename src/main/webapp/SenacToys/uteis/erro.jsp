<%-- 
    Document   : sucesso
    Created on : 17/09/2021, 21:20:00
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>
    <head>
        <title>Erro</title>
    </head>
    <body class="container">
        <div class="bg">
            <div>
                <h1>Erro na operação, tente novamente!</h1>
                <a href="${pageContext.request.contextPath}/index.jsp"><button class="back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

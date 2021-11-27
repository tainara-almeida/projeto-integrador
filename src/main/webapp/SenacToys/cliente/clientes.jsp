<%-- 
    Document   : clientes
    Created on : 23/11/2021, 11:12:28
    Author     : Andrew
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>
    <head>
        <title>Clientes</title>
    </head>
    <body class="container">

        <div class="bg">
            <h1 class="title">Funcionalidades clientes</h1>

            <nav class="container menu">
                <ul>
                    <li><a href="cadastro.jsp">Cadastrar Cliente</a></li>
                    <li><a href="buscarCliente.jsp">Buscar Cliente</a></li>
                    <div><a href="${pageContext.request.contextPath}/SenacToys/index.jsp"><button class="btn btn-primary back">Voltar</button></a></div>
                </ul>
            </nav>
        </div>
    </body>
</html>

<%-- 
    Document   : funcionarios
    Created on : 23/11/2021, 14:14:59
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
            <h1 class="title">Funcionalidades Funcionarios</h1>

            <nav class="container menu">
                <ul>
                    <li><a href="cadastro.jsp">Cadastrar Funcionario</a></li>
                    <li><a href="buscarFuncionario.jsp">Buscar Funcionario</a></li>
                    <div><a href="${pageContext.request.contextPath}/SenacToys/index.jsp"><button class="btn btn-primary back">Voltar</button></a></div>
                </ul>
            </nav>
        </div>
    </body>
</html>

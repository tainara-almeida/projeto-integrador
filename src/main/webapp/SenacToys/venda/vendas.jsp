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
            <h1 class="title">Funcionalidades Vendas</h1>

            <nav class="container menu">
                <ul>
                    <c:if test="${sessionScope.usuario.isAdmin() || sessionScope.usuario.isSeller()}">
                        <li><a href="${pageContext.request.contextPath}/SenacToys/venda/VendaServlet">Cadastrar Venda</a></li>
                    </c:if>
                    <c:if test="${sessionScope.usuario.isAdmin() || sessionScope.usuario.isManager()}">
                        <li><a href="${pageContext.request.contextPath}/SenacToys/venda/VendaServlet">Relatórios</a></li>
                    </c:if>
                   
                    <div><a href="${pageContext.request.contextPath}/SenacToys/index.jsp"><button class="btn btn-primary back">Voltar</button></a></div>
                </ul>
            </nav>
        </div>
    </body>
</html>

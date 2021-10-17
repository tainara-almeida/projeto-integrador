<%-- 
    Document   : index
    Created on : 17/09/2021, 20:58:31
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <c:import url="uteis/header.jsp"/>
        <div>Menu</div>
        <a href="cliente/cadastro.jsp">Cadastrar Cliente</a><br/>
        <a href="cliente/ListarClienteServlet">Listar Cliente</a><br/>
        <a href="cliente/buscarCliente.jsp">Buscar Cliente</a>
    </body>
</html>

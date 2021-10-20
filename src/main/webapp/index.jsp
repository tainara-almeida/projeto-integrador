<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="uteis/header.jsp"/>
    <head>
        <title>CRUD Cliente</title>
    </head>
    <body class="container">

        <div class="bg">
            <h1 class="title">Busca por nome de cliente</h1>

            <nav class="container menu">
                <ul>
                    <li><a href="cliente/cadastro.jsp">Cadastrar Cliente</a></li>
                    <li><a href="cliente/ListarClienteServlet">Listar Cliente</a></li>
                    <li><a href="cliente/buscarCliente.jsp">Buscar Cliente</a></li>
                </ul>
            </nav>
        </div>
    </body>
</html>

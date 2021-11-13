<%-- 
    Document   : buscarCliente
    Created on : 02/11/2021, 11:13:01
    Author     : Andrew
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>

    <head>
        <title>Buscar Clientes</title>
        <script type="text/javascript">

        </script>
    </head>
    <body class="container">
        <div class="bg">

            <div>
                <h1>Clientes</h1>
                <form action="ClienteServlet" method="GET">
                    <input type="text" name="nomeCliente" value="${clienteBusca.nomeCliente}" placeholder="Nome"
                        required class="form-control"/><br/> 
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                
                <table  class="table">
                <thead>
                    <td>Nome</td><td>Email</td><td>CPF</td>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${listaClientes}">
                        <tr>
                            <td>${cliente.nome}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.cpf}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/index.jsp"><button class="btn btn-primary back">Voltar</button></a>
        </div>
    </div>
</body>
</html>

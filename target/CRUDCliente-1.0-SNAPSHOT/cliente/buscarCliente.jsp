<%-- 
    Document   : buscarCliente
    Created on : 15/10/2021, 16:15:40
    Author     : Andrew
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar de Clientes</title>
        <script type="text/javascript">

        </script>
    </head>
    <body class="container">
        <c:import url="../uteis/header.jsp"/>
        <h1>Clientes</h1>
        <form action="BuscarClienteServlet" method="GET">
            <c:if test="${not empty clienteBusca}">
                <input type="hidden" name="ope" value="1"/>
            </c:if>
            <div  class="form-group">
                <label>Nome</label>
                <input type="text" name="nomeCliente" value="${clienteBusca.nomeUsuario}"
                       required class="form-control"/><br/> 
            </div>
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

</body>
<a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
</html>
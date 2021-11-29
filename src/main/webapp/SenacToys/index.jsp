<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="uteis/header.jsp"/>
    <head>
        <title>Senac Toys</title>
    </head>
    <body class="container">

        <div class="bg">
            <h1 class="title">Home</h1>

            <nav class="container menu">
                <ul>
                    <li><a href="${pageContext.request.contextPath}cliente/clientes.jsp">Clientes</a></li>
                    
                    <c:if test="${sessionScope.usuario.isAdmin() || sessionScope.usuario.isManager()}">
                        <li><a href="${pageContext.request.contextPath}produto/produtos.jsp">Produtos</a></li>
                    </c:if>
                    
                    <c:if test="${sessionScope.usuario.isAdmin()}">
                        <li><a href="${pageContext.request.contextPath}funcionario/funcionarios.jsp">Funcionarios</a></li>
                    </c:if>
                        
                        <li><a href="${pageContext.request.contextPath}venda/vendas.jsp">Vendas</a></li>
                    
                </ul>
            </nav>
        </div>
    </body>
</html>

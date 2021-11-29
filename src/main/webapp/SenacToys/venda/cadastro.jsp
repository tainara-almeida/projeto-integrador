<%-- 
    Document   : cadastro
    Created on : 23/11/2021, 14:20:19
    Author     : Andrew
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>

    <head>
        <title>Cadastro de Venda</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <h1 class="title">Vendas</h1>
                
                <table  class="table">
                <thead>
                    <td>Código</td>
                    <td>Nome</td>
                    <td>Categoria</td>
                    <td>Idade</td>
                    <td>Descrição</td>
                    <td>Preço</td>
                    <td>Imagem</td>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProdutos}">
                        <tr>
                            <td>${produto.codProduto}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.categoria}</td>
                            <td>${produto.classificacaoIdade}</td>
                            <td>${produto.descricao}</td>
                            <td>${produto.precoUnitario}</td>
                            <td><img src="${produto.imgUrl}" alt="Imagem" height="50" width="50"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/SenacToys/venda/vendas.jsp"><button class="btn btn-primary back">Voltar</button></a>
    </body>
</html>

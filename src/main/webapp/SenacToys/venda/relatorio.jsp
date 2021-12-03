<%-- 
    Document   : cadastro
    Created on : 23/11/2021, 14:20:19
    Author     : Andrew
--%>

<%@page import="com.pi.entities.Produto"%>
<%@page import="java.util.List"%>
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
                <table id="tb1" class="table">
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
                                <td id="preco">${produto.precoUnitario}</td>
                                <td><img src="${produto.imgUrl}" alt="Imagem" height="50" width="50"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        
            <div class="bg">
                <form action="FuncionarioServlet" method="POST">
                    
                </form>
            </div>
        </div>
    </body>
</html>

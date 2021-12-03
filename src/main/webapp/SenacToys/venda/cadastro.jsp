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
        <div>
            <div class="bg">
                <table id="tb1" class="table">
                <thead>
                    <td>Código</td>
                    <td>Nome</td>
                    <td>Preço</td>
                    <td>Imagem</td>
                </thead>
                    <tbody>
                        <c:forEach var="produto" items="${listaProdutos}">
                            <tr>
                                <td>${produto.codProduto}</td>
                                <td>${produto.nome}</td>
                                <td id="preco">${produto.precoUnitario}</td>
                                <td><img src="${produto.imgUrl}" alt="Imagem" height="50" width="50"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        
            <div class="bg">
                <form action="VendaServlet" method="POST">
                    <input type="hidden" name="_method" value="post"/>
                    <input type="text" name="codCliente" value="${cliente.codCliente}" placeholder="Código Cliente"
                            required class="form-control"/>
                    <input type="text" name="codProduto" value="${produto.codProduto}" placeholder="Código do produto"
                        required class="form-control"/>
                    <input type="text" name="dataVenda" value="${venda.dataVenda}" placeholder="Data da venda"
                        required class="form-control"/>
                    <input type="text" name="quantidade" value="${produto.quantidade}" placeholder="Quantidade"
                        required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>
    </body>
</html>

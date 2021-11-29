<%-- 
    Document   : atualizar
    Created on : 20 de out de 2021, 20:08:08
    Author     : andrew.dornelas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../uteis/header.jsp"/>
        <title>JSP Page</title>
    </head>
    <body class="container">
        <div class="bg">

            <div>
                <h1>Atualizar dados do Produto</h1>
                
                <c:forEach var="produto" items="${listaProdutos}">
                    <form action="ProdutoServlet" method="POST">
                        <input type="hidden" name="_method" value="PUT"/>
                        <input type="hidden" name="codProduto" value="${produto.codProduto}" placeholder="código"
                                required class="form-control"/>
                        <input type="text" name="categoriaProduto" value="${produto.categoria}" placeholder="Categoria"
                                required class="form-control"/>
                        <input type="text" name="nomeProduto" value="${produto.nome}" placeholder="Nome"
                            required class="form-control"/>
                        <input type="text" name="descricaoProduto" value="${produto.descricao}" placeholder="Descrição"
                            required class="form-control"/>
                        <input type="text" name="classificacaoProduto" value="${produto.classificacaoIdade}" placeholder="Faixa etária"
                            required class="form-control"/>
                        <input type="text" name="precoProduto" value="${produto.precoUnitario}" placeholder="Valor"
                            required class="form-control"/>
                        <input type="text" name="urlProduto" value="${produto.imgUrl}" placeholder="Cadastre uma URL para Imagem"
                            required class="form-control"/>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/SenacToys/produto/buscarProduto.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

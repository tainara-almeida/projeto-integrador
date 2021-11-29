<%-- 
    Document   : cadastro
    Created on : 17/09/2021, 21:00:14
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>

    <head>
        <title>Cadastro de Produtos</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <h1 class="title">Cadastro de Produtos</h1>

                <form action="ProdutoServlet" method="POST">
                    <input type="hidden" name="_method" value="post"/>
                    <input type="text" name="categoriaProduto" value="${produto.categoriaProduto}" placeholder="Categoria"
                            required class="form-control"/>
                    <input type="text" name="nomeProduto" value="${produto.nomeProduto}" placeholder="Nome"
                        required class="form-control"/>
                    <input type="text" name="descricaoProduto" value="${produto.descricaoProduto}" placeholder="Descrição"
                        required class="form-control"/>
                    <input type="text" name="classificacaoProduto" value="${produto.classificacaoProduto}" placeholder="Faixa etária"
                        required class="form-control"/>
                    <input type="text" name="precoProduto" value="${produto.precoProduto}" placeholder="Valor"
                        required class="form-control"/>
                    <input type="text" name="urlProduto" value="${produto.urlProduto}" placeholder="Cadastre uma URL para Imagem"
                        required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
                <a href="${pageContext.request.contextPath}/SenacToys/produto/produtos.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

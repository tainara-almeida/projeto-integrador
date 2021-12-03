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
                <table id="tb1" class="table">
                <thead>
                    <td>Código</td>
                    <td>Nome</td>
                    <td>Categoria</td>
                    <td>Idade</td>
                    <td>Descrição</td>
                    <td>Preço</td>
                    <td>Imagem</td>
                    <td></td>
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
                                <td><input type="checkbox" name="sel" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        
            <div>
                <button type="button" id="importar" class="btn btn-primary back">Importar</button>
            </div>
            <div class="bg">
                <form action="action">
                    <table id="tb2" class="table">
                    <thead>
                        <td>Código</td>
                        <td>Nome</td>
                        <td>Categoria</td>
                        <td>Idade</td>
                        <td>Descrição</td>
                        <td>Preço</td>
                        <td>Imagem</td>
                        <td>Qtd</td>
                    </thead>
                        <tbody>
                            <tr>
                                <td>${produto.codProduto}</td>
                                <td>${produto.nome}</td>
                                <td>${produto.categoria}</td>
                                <td>${produto.classificacaoIdade}</td>
                                <td>${produto.descricao}</td>
                                <td>${produto.precoUnitario}</td>
                                <td><img src="${produto.imgUrl}" alt="Imagem" height="50" width="50"/></td>
                                <td>${produto.quantidade}</td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
    <script>
        $('#importar').click(function(){
        $("#tb2 tbody").html('');//limpa a tabela 2
            //percorre todos os checkbox marcados na tabela 1
          $('#tb1 tbody tr td input[type=checkbox]:checked').each(function(){
            var $tr = $(this).parents('tr').clone().append('<td><input type="number"/></td>"'); // clona a tr
            $tr.find('td:eq(7)').remove(); // remove a primeira coluna
            $("#tb2 tbody").append($tr); // coloca na tabela 2
        })
      });
    </script>
</html>

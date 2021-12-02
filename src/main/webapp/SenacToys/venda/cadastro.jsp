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
        <script>
                    (function($) {
                        remove = function(item) {
                          var tr = $(item).closest('tr');

                          tr.fadeOut(400, function() {
                            tr.remove();  
                          });

                          return false;
                        }
                      })(jQuery);
                    (function($) {
                        AddTableRow = function() {

                          var newRow = $("<tr>");
                          var cols = "";

                          cols += '<td>&nbsp;</td>';
                          cols += '<td>&nbsp;</td>';
                          cols += '<td>&nbsp;</td>';
                          cols += '<td>${produto.precoUnitario}</td>';
                          cols += '<td>&nbsp;</td>';
                          cols += '<td>';
                          cols += '<button onclick="remove(this)" type="button" class="btn btn-primary">Remover</button>';
                          cols += '</td>';

                          newRow.append(cols);
                          $("#products-table").append(newRow);

                          return false;
                        };
                      })(jQuery);
                </script>
    </head>
    <body class="container">
        <div class="bg">
            <h1 class="title">Vendas</h1>
            <div class="row g-0">
                <table  class="table col-9">
                    <thead>
                        <td>Código</td>
                        <td>Nome</td>
                        <td>Descrição</td>
                        <td>Preço</td>
                        <td>Imagem</td>
                        <td>Ação</td>
                    </thead>
                    <tbody>
                        <form>
                            <c:forEach var="produto" items="${listaProdutos}">
                                <tr>
                                    <td>${produto.codProduto}</td>
                                    <td>${produto.nome}</td>
                                    <td>${produto.descricao}</td>
                                    <td>${produto.precoUnitario}</td>
                                    <td><img src="${produto.imgUrl}" alt="Imagem" height="50" width="50"/></td>
                                    <td><button onclick="AddTableRow()" type="button" class="btn btn-primary">Adicionar Produto</button></td>
                                </tr>
                            </c:forEach>
                        </form>
                    </tbody>
                </table>
            </div>
                
            <div class="row g-0">
                <table  class="table col-9" id="products-table">
                    <thead>
                        <td>Código</td>
                        <td>Nome</td>
                        <td>Descrição</td>
                        <td>Preço</td>
                        <td>Imagem</td>
                        <td>Ação</td>
                    </thead>
                    <tbody>
                        <form>
                            <tr>
                                <td>${produto.codProduto}</td>
                                <td>${produto.nome}</td>
                                <td>${produto.descricao}</td>
                                <td>${produto.precoUnitario}</td>
                                <td><img src="${produto.imgUrl}" alt="Imagem" height="50" width="50"/></td>
                            </tr>
                        </form>
                    </tbody>
                </table>
            </div>
                <a href="${pageContext.request.contextPath}/SenacToys/venda/vendas.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
    </body>
</html>

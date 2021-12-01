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
        <title>Buscar Produtos</title>
        
        <script type="text/javascript">
            var codRemoçao;
            function confirmarRemocao(nome, codProduto) {
                console.log("Confirmar exclusao ", nome, codProduto);
                codRemoçao = codProduto;
                var paragrafoProduto = $("#campoTextoExclusao");
                paragrafoProduto.html(nome + " - " + codProduto);
                
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.show();
            }
            
            function fecharModal() {
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.hide();
            }

            function deletar() {
                console.log("Excluindo produto ", codRemoçao);
                fecharModal();
                var url = "ProdutoServlet?codProduto=" + codRemoçao + "&operacao=deletar";
                $.ajax(url).done(function () {
                    console.log("Produto removido!");
                    var alerta = $("#alerta");
                    alerta.css("display", "block");
                    setTimeout(function(){
                         alerta.css("display", "none");
                         location.reload();
                    }, 1000)
                }).fail(function () {
                    console.log("Erro ao remover o produto!");
                })
            }

        </script>
    </head>
    <body class="container">
        <div class="bg">

            <div>
                <h1>Produtos</h1>
                <form action="ProdutoServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="nomeProduto" value="${produto.nomeProduto}" placeholder="Nome"
                        required class="form-control"/><br/>
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                <form action="ProdutoServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="codProduto" value="${produto.codProduto}" placeholder="Código"
                        required class="form-control"/><br/> 
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                <form action="ProdutoServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="categoriaProduto" value="${produto.categoriaProduto}" placeholder="Categoria"
                        required class="form-control"/><br/> 
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                
                        
                <div class="modal" tabindex="-1" role="dialog" id="modalExclusao">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Confirmar Exclusão</h5>                       
                            </div>
                            <div class="modal-body">
                                <p>Confirmar exclusão do produto abaixo?</p>
                                <p id="campoTextoExclusao"></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" onclick="fecharModal()">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="deletar()">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>
                        
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
                            <td><a href="ProdutoServlet?codProduto=${produto.codProduto}&operacao=atualizar" class="btn btn-link">Atualizar</a></td>
                            <td><button onclick="confirmarRemocao('${produto.nome}', '${produto.codProduto}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/SenacToys/produto/produtos.jsp"><button class="btn btn-primary back">Voltar</button></a>
        </div>
    </div>
</body>
</html>

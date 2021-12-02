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
            var cpfRemocao;
            function confirmarRemocao(nome, cpf) {
                console.log("Confirmar exclusao ", nome, cpf);
                cpfRemocao = cpf;
                var paragrafoCliente = $("#campoTextoExclusao");
                paragrafoCliente.html(nome + " - " + cpf);
                
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.show();
            }
            
            function fecharModal() {
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.hide();
            }

            function deletar() {
                console.log("Excluindo cliente ", cpfRemocao);
                fecharModal();
                var url = "ClienteServlet?cpfCliente=" + cpfRemocao + "&operacao=deletar";
                $.ajax(url).done(function () {
                    console.log("Cliente removido!");
                    var alerta = $("#alerta");
                    alerta.css("display", "block");
                    setTimeout(function(){
                         alerta.css("display", "none");
                         location.reload();
                    }, 1000)
                }).fail(function () {
                    console.log("Erro ao remover o cliente!");
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
                                <p>Confirmar exclusão do usuário abaixo?</p>
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
                            <td><button onclick="confirmarRemocao('${cliente.nome}', '${cliente.cpf}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/SenacToys/produto/produtos.jsp"><button class="btn btn-primary back">Voltar</button></a>
        </div>
    </div>
</body>
</html>

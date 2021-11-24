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
        <title>Buscar Clientes</title>
        
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
                <h1>Clientes</h1>
                <form action="ClienteServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="nomeCliente" value="${clienteBusca.nomeCliente}" placeholder="Nome"
                        required class="form-control"/><br/>
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                <form action="ClienteServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="cpfCliente" value="${clienteBusca.cpfCliente}" placeholder="CPF"
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
                    <td>Nome</td><td>Email</td><td>CPF</td>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${listaClientes}">
                        <tr>
                            <td>${cliente.nome}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.cpf}</td>
                            <td><a href="ClienteServlet?cpfCliente=${cliente.cpf}&operacao=atualizar" class="btn btn-link">Atualizar</a></td>
                            <td><button onclick="confirmarRemocao('${cliente.nome}', '${cliente.cpf}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/SenacToys/cliente/clientes.jsp"><button class="btn btn-primary back">Voltar</button></a>
        </div>
    </div>
</body>
</html>

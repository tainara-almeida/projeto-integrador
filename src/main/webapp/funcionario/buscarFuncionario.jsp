<%-- 
    Document   : buscarFuncionario
    Created on : 23/11/2021, 15:36:28
    Author     : Andrew
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>

    <head>
        <title>Buscar Funcionarios</title>
        
        <script type="text/javascript">
            var cpfRemocao;
            function confirmarRemocao(nome, cpf) {
                console.log("Confirmar exclusao ", nome, cpf);
                cpfRemocao = cpf;
                var paragrafoFuncionario = $("#campoTextoExclusao");
                paragrafoFuncionario.html(nome + " - " + cpf);
                
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.show();
            }
            
            function fecharModal() {
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.hide();
            }

            function deletar() {
                console.log("Excluindo Funcionario ", cpfRemocao);
                fecharModal();
                var url = "FuncionarioServlet?cpfFuncionario=" + cpfRemocao + "&operacao=deletar";
                $.ajax(url).done(function () {
                    console.log("Funcionario removido!");
                    var alerta = $("#alerta");
                    alerta.css("display", "block");
                    setTimeout(function(){
                         alerta.css("display", "none");
                         location.reload();
                    }, 1000)
                }).fail(function () {
                    console.log("Erro ao remover o Funcionario!");
                })
            }

        </script>
    </head>
    <body class="container">
        <div class="bg">

            <div>
                <h1>Funcionarios</h1>
                <form action="FuncionarioServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="nomeFuncionario" value="${funcionarioBusca.nomeFuncionario}" placeholder="Nome"
                        required class="form-control"/><br/>
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                <form action="FuncionarioServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="cpfFuncionario" value="${funcionarioBusca.cpfFuncionario}" placeholder="CPF"
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
                    <c:forEach var="funcionario" items="${listaFuncionarios}">
                        <tr>
                            <td>${funcionario.nome}</td>
                            <td>${funcionario.email}</td>
                            <td>${funcionario.cpf}</td>
                            <td><a href="FuncionarioServlet?cpfFuncionario=${funcionario.cpf}&operacao=atualizar" class="btn btn-link">Atualizar</a></td>
                            <td><button onclick="confirmarRemocao('${funcionario.nome}', '${funcionario.cpf}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/funcionario/funcionarios.jsp"><button class="btn btn-primary back">Voltar</button></a>
        </div>
    </div>
</body>
</html>


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
        <title>Cadastro de acesso de Funcionario</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <h1 class="title">Formulário de Funcionarios</h1>
                
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                

                <form action="AcessoServlet" method="POST">
                    <input type="hidden" name="_method" value="post"/>
                    <input type="text" name="cpfFuncionario" value="${funcionarioCadastro.cpf}" placeholder="CPF"
                            required class="form-control"/>
                    <input type="text" name="setorFuncionario" value="${funcionarioCadastro.setor}" placeholder="Setor"
                        required class="form-control"/>
                    <input type="text" name="empresaCNPF" value="${funcionarioCadastro.empresaCNPJ}" placeholder="CNPJ Filial"
                        required class="form-control"/>
                    <input type="text" name="loginFuncionario" value="${funcionarioCadastro.login}" placeholder="Login"
                            required class="form-control"/>
                    <input type="password" name="senhaFuncionario" value="${funcionarioCadastro.senha}" placeholder="Senha"
                        required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
                <a href="${pageContext.request.contextPath}/SenacToys/funcionario/funcionarios.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

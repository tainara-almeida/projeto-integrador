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
        <title>Cadastro de Funcionario</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <h1 class="title">Formulário de Funcionarios</h1>

                <form action="FuncionarioServlet" method="POST">
                    <input type="hidden" name="_method" value="post"/>
                    <input type="text" name="cpfFuncionario" value="${funcionarioCadastro.cpf}" placeholder="CPF"
                            required class="form-control"/>
                    <input type="text" name="nomeFuncionario" value="${funcionarioCadastro.nome}" placeholder="Nome"
                        required class="form-control"/>
                    <input type="text" name="emailFuncionario" value="${funcionarioCadastro.email}" placeholder="Email"
                        required class="form-control"/>
                    <input type="text" name="dataFuncionario" value="${funcionarioCadastro.data}" placeholder="Data de Nascimento"
                        required class="form-control"/>
                    <input type="text" name="telefoneFuncionario" value="${funcionarioCadastro.telefone}" placeholder="Telefone"
                        required class="form-control"/>
                    <input type="text" name="enderecoFuncionario" value="${funcionarioCadastro.endereco}" placeholder="Endereço"
                        required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
                <a href="${pageContext.request.contextPath}/funcionario/funcionarios.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

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
        <title>Cadastro de Clientes</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <h1 class="title">Formulário de Clientes</h1>

                <form action="ClienteServlet" method="POST">
                    <input type="hidden" name="_method" value="post"/>
                    <input type="text" name="cpfCliente" value="${clienteCadastro.cpf}" placeholder="CPF"
                            required class="form-control"/>
                    <input type="text" name="nomeCliente" value="${clienteCadastro.nome}" placeholder="Nome"
                        required class="form-control"/>
                    <input type="text" name="emailCliente" value="${clienteCadastro.email}" placeholder="Email"
                        required class="form-control"/>
                    <input type="text" name="dataCliente" value="${clienteCadastro.data}" placeholder="Data de Nascimento"
                        required class="form-control"/>
                    <input type="text" name="telefoneCliente" value="${clienteCadastro.telefone}" placeholder="Telefone"
                        required class="form-control"/>
                    <input type="text" name="enderecoCliente" value="${clienteCadastro.endereco}" placeholder="Endereço"
                        required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
                <a href="${pageContext.request.contextPath}/SenacToys/cliente/clientes.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

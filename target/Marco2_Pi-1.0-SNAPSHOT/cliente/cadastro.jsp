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

                <form action="CadastroClienteServlet" method="POST">
                    <c:if test="${not empty clienteAtualizacao}">
                        <input type="hidden" name="ope" value="1"/>
                    </c:if>
                        <c:if test="${empty clienteAtualizacao}">
                            <input type="text" name="cpfCliente" placeholder="CPF"
                                value="${clienteAtualizacao.cpf}" 
                                required
                                class="form-control"
                                />
                        </c:if>
                        <input type="text" name="nomeCliente" value="${clienteAtualizacao.nome}" placeholder="Nome"
                            required class="form-control"/>
                        <input type="text" name="emailCliente" value="${clienteAtualizacao.email}" placeholder="Email"
                            required class="form-control"/>
                        <input type="text" name="emailCliente" value="${clienteAtualizacao.email}" placeholder="Data de Nascimento"
                            required class="form-control"/>
                        <input type="text" name="emailCliente" value="${clienteAtualizacao.email}" placeholder="Telefone"
                            required class="form-control"/>
                        <input type="text" name="emailCliente" value="${clienteAtualizacao.email}" placeholder="Endereço"
                            required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
                <a href="${pageContext.request.contextPath}/index.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

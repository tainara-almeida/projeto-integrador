<%-- 
    Document   : atualizar
    Created on : 20 de out de 2021, 20:08:08
    Author     : andrew.dornelas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../uteis/header.jsp"/>
        <title>JSP Page</title>
    </head>
    <body class="container">
        <div class="bg">

            <div>
                <h1>Atualizar dados do Cliente</h1>
                
                <c:forEach var="cliente" items="${listaClientes}">
                    <form action="ClienteServlet" method="POST">
                        <input type="hidden" name="_method" value="PUT" />
                        <input type="hidden" name="cpfCliente" value="${cliente.cpf}" placeholder="CPF"
                                required class="form-control"/>
                            <input type="text" name="nomeCliente" value="${cliente.nome}" placeholder="Nome"
                                required class="form-control"/>
                            <input type="text" name="emailCliente" value="${cliente.email}" placeholder="Email"
                                required class="form-control"/>
                            <input type="text" name="dataCliente" value="${cliente.dataNascimento}" placeholder="Data de Nascimento"
                                required class="form-control"/>
                            <input type="text" name="telefoneCliente" value="${cliente.telefone}" placeholder="Telefone"
                                required class="form-control"/>
                            <input type="text" name="enderecoCliente" value="${cliente.endereco}" placeholder="Endereço"
                                required class="form-control"/>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/SenacToys/cliente/clientes.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>

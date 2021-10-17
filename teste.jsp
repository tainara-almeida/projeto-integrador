<%-- 
    Document   : cadastro
    Created on : 17/09/2021, 21:00:14
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar de Clientes</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <table>
            <thead>
            <td>Nome</td><td>Email</td><td>CPF</td>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${listaClientes}">
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td><a href="CadastroClienteServlet?cpfUsuario=${cliente.cpf}&ope=1" >Atualizar</a></td>
                        <td><a href="CadastroClienteServlet?cpfUsuario=${cliente.cpf}">Deletar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            
            
        </table>
       
    </body>
    <a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
</html>

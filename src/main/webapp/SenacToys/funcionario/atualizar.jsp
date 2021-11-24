<%-- 
    Document   : atualizar
    Created on : 23/11/2021, 15:36:36
    Author     : Andrew
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
                <h1>Atualizar dados do Funcionario</h1>
                
                <c:forEach var="funcionario" items="${listaFuncionarios}">
                    <form action="FuncionarioServlet" method="POST">
                        <input type="hidden" name="_method" value="PUT" />
                        <input type="hidden" name="cpfFuncionario" value="${funcionario.cpf}" placeholder="CPF"
                                required class="form-control"/>
                            <input type="text" name="nomeFuncionario" value="${funcionario.nome}" placeholder="Nome"
                                required class="form-control"/>
                            <input type="text" name="emailFuncionario" value="${funcionario.email}" placeholder="Email"
                                required class="form-control"/>
                            <input type="text" name="dataFuncionario" value="${funcionario.dataNascimento}" placeholder="Data de Nascimento"
                                required class="form-control"/>
                            <input type="text" name="telefoneFuncionario" value="${funcionario.telefone}" placeholder="Telefone"
                                required class="form-control"/>
                            <input type="text" name="enderecoFuncionario" value="${funcionario.endereco}" placeholder="Endereço"
                                required class="form-control"/>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/SenacToys/funcionario/funcionarios.jsp"><button class="btn btn-primary back">Voltar</button></a>
            </div>
        </div>
    </body>
</html>


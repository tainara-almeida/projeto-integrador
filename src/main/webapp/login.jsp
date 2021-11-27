<%-- 
    Document   : login
    Created on : 24/11/2021, 12:55:25
    Author     : Andrew
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="SenacToys/uteis/header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body class="container">

        <div class="bg">
            <div>
                <h1 class="title">Login</h1>
                <c:if test="${param.loginInvalido != null}">
                    <div class="alert alert-danger" role="alert">
                        Usuário ou Senha inválidos!
                    </div>
                </c:if>

                <form action="LoginServlet" method="POST">
                    <input type="hidden" name="_method" value="post"/>
                    <input type="text" name="nomeUsuario" value="${usuario.nome}" placeholder="Usuário"
                        required class="form-control"/>
                    <input type="password" name="senhaUsuario" value="${usuario.nome}" placeholder="Senha"
                        required class="form-control"/>
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </form>
            </div>
        </div>
    </body>
</html>

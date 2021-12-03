<%-- 
    Document   : cadastro
    Created on : 23/11/2021, 14:20:19
    Author     : Andrew
--%>

<%@page import="com.pi.entities.Produto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>

    <head>
        <title>Cadastro de Venda</title>
    </head>
    
    <body class="container">
        <div class="bg">

            <div>
                <h1>Relatórios</h1>
                <form action="RelatorioServlet" method="GET">
                    <input type="hidden" name="operacao" value="busca" />
                    <input type="text" name="dataInicio" value="${relatorio.dataInicio}" placeholder="Data Inicio"
                        required class="form-control"/><br/>
                    <input type="text" name="dataFim" value="${relatorio.dataFim}" placeholder="Data Fim"
                        required class="form-control"/><br/>
                    <button type="submit" class="btn btn-primary">Buscar</button><br/>
                </form>
                
                
                <table  class="table">
                <thead>
                    <td>Código da venda</td>
                    <td>Código do produto</td>
                    <td>Nome do cliente</td>
                    <td>Data da venda</td>
                    <td>Nome do produto</td>
                    <td>Quantidade</td>
                    <td>Preço unitario</td>
                    <td>Preço total</td>
                </thead>
                <tbody>
                    <c:forEach var="relatorio" items="${listaRelatorio}">
                        <tr>
                            <td>${relatorio.codVenda}</td>
                            <td>${relatorio.codProduto}</td>
                            <td>${relatorio.nomeCliente}</td>
                            <td>${relatorio.dataVenda}</td>
                            <td>${relatorio.nomeProduto}</td>
                            <td>${relatorio.quantidade}</td>
                            <td>${relatorio.precoUnitario}</td>
                            <td>${relatorio.valorTotalVenda}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/SenacToys/venda/vendas.jsp"><button class="btn btn-primary back">Voltar</button></a>
        </div>
    </div>
</body>
</html>

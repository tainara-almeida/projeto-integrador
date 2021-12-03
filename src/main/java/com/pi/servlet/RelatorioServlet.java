/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.RelatorioDaoImpl;
import com.pi.entities.Relatorio;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dataInicio = req.getParameter("dataInicio");
        String dataFim = req.getParameter("dataFim");
        
        List<Relatorio> listaRelatorio = RelatorioDaoImpl.buscarRelatorios(dataInicio, dataFim);
        req.setAttribute("listaRelatorio", listaRelatorio);
        
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SenacToys/venda/relatorio.jsp");
        requestDispatcher.forward(req, resp);
    }
    
}

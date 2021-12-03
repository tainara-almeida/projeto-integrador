/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.ProdutoDaoImpl;
import com.pi.entities.Produto;
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
public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Produto> listaProdutos = ProdutoDaoImpl.getProdutos();
        req.setAttribute("listaProdutos", listaProdutos);
        
         RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SenacToys/venda/relatorio.jsp");
         requestDispatcher.forward(req, resp);
            
    }
    
}

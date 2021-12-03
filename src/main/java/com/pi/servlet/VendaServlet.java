/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.ProdutoDaoImpl;
import com.pi.dao.VendaDaoImpl;
import com.pi.entities.Produto;
import com.pi.entities.Venda;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
         RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SenacToys/venda/cadastro.jsp");
         requestDispatcher.forward(req, resp);
            
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codCliente = req.getParameter("codCliente");
        String codProduto = req.getParameter("codProduto");
        String dataVenda = req.getParameter("dataVenda");
        String quantidade = req.getParameter("quantidade");
        
        Venda venda = new Venda();
        
        venda.setCodCliente(Integer.parseInt(codCliente));
        venda.setCodProduto(Integer.parseInt(codProduto));
        venda.setDataVenda(dataVenda);
        venda.setQuantidade(Integer.parseInt(quantidade));
        
        try {
            boolean resposta = VendaDaoImpl.inserirVenda(venda);
            if(resposta){
                    String sucesso = "/SenacToys/venda/sucesso.jsp";
                    String urlVoltar = "/SenacToys/venda/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/venda/erro.jsp";
                    String urlVoltar = "/SenacToys/venda/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
        } catch (IOException | ServletException e) {
            String erro = "/SenacToys/venda/erro.jsp";
            String urlVoltar = "/SenacToys/venda/funcionarios.jsp";
            req.setAttribute("urlVoltar", urlVoltar);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
            dispatcher.forward(req,resp);
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
}

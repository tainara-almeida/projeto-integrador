/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.ClienteDao;
import com.pi.entities.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andrew.dornelas
 */
@WebServlet(name = "AtualizarCliente", urlPatterns = {"/AtualizarCliente"})
public class AtualizarCliente extends HttpServlet {
    ClienteDao clienteDao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String cpf = req.getParameter("cpfUsuario");
        Cliente cliente = clienteDao.getClientePorCPF(cpf);
        req.setAttribute("clienteAtualizacao", cliente);
        req.getRequestDispatcher("/cliente/atualizar.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

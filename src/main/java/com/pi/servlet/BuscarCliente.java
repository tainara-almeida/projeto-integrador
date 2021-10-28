/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.ClienteDao;
import com.pi.entities.Cliente;
import com.pi.facade.ClienteFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "BuscarCliente", urlPatterns = {"/BuscarCliente"})
public class BuscarCliente extends HttpServlet {
    
    ClienteDao clienteDAO;
    ClienteFacade clienteFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeBusca = request.getParameter("nomeCliente");
        String cpfBusca = request.getParameter("cpfCliente");
        
        if(cpfBusca != null && !cpfBusca.equals("")){
            Cliente cliente = clienteFacade.buscarClientePorCpf(cpfBusca);
            request.setAttribute("listaClientes", cliente);
        
            String url = "/cliente/buscarCliente.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }else if(nomeBusca != null && !nomeBusca.equals("")){
            List<Cliente> clientes = clienteFacade.buscarClientePorNome(nomeBusca);
            request.setAttribute("listaClientes", clientes);
        
            String url = "/cliente/buscarCliente.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }else{
            List<Cliente> clientes = clienteFacade.buscarCliente();
            request.setAttribute("listaClientes", clientes);
        
            String url = "/cliente/buscarCliente.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        
        /*List<Cliente> clientes = clienteDAO.getClientePorNome(nomeBusca);
        request.setAttribute("listaClientes", clientes);
        
        // RequestDispatcher reaproveita os objetos Request e Response
        String url = "/cliente/buscarCliente.jsp";
        request.getRequestDispatcher(url).forward(request, response);
        
        //sendRedirect sempre cria um novo request/response
        //response.sendRedirect("listar.jsp");*/
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.entities.Cliente;
import com.pi.facade.ClienteFacadeImpl;
import java.io.IOException;
import java.util.ArrayList;
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
public class ClienteServlet extends HttpServlet {

    ClienteFacadeImpl clienteFacade = new ClienteFacadeImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeBusca = req.getParameter("nomeCliente");
        String cpfBusca = req.getParameter("cpfCliente");
        
        if(cpfBusca != null && !cpfBusca.equals("")){
            Cliente cliente = clienteFacade.buscarClientePorCpf(cpfBusca);
            req.setAttribute("listaClientes", cliente);
        
            String url = "/cliente/buscarCliente.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
        }else if(nomeBusca != null && !nomeBusca.equals("")){
            try{
                List<Cliente> clientes = new ArrayList<>();
                Cliente cliente = new Cliente();
                clientes = clienteFacade.buscarClientePorNome(nomeBusca);
                req.setAttribute("listaClientes", clientes);

                String url = "/cliente/buscarCliente.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(req,resp);
            }catch(NullPointerException | ServletException e){
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            List<Cliente> clientes = new ArrayList<>();
            clientes = clienteFacade.buscarCliente();
            req.setAttribute("listaClientes", clientes);
        
            String url = "/cliente/buscarCliente.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
        }
        
    }
}

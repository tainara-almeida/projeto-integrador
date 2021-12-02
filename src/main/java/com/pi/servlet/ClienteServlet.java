/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.entities.Cliente;
import com.pi.facade.ClienteFacade;
import com.pi.facade.ClienteFacadeImpl;
import com.pi.uteis.Formatador2;
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

    ClienteFacade clienteFacade = new ClienteFacadeImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeBusca = req.getParameter("nomeCliente");
        String cpfBusca = req.getParameter("cpfCliente");
        String operacao = req.getParameter("operacao");
        
        if(cpfBusca != null && !cpfBusca.equals("")){
            List<Cliente> clientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            
            if(operacao.equals("deletar")){
                doDelete(req, resp);
            }
            
            cliente = clienteFacade.buscarClientePorCpf(cpfBusca);
            clientes.add(cliente);
            req.setAttribute("listaClientes", clientes);
        
            String url = "";
            
            switch(operacao){
                case "busca":
                    url = "/SenacToys/cliente/buscarCliente.jsp";
                    break;
                case "atualizar":
                    url = "/SenacToys/cliente/atualizar.jsp";
                    break;
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
            
        }else if(nomeBusca != null && !nomeBusca.equals("")){
            try{
                List<Cliente> clientes = new ArrayList<>();
                Cliente cliente = new Cliente();
                clientes = clienteFacade.buscarClientePorNome(nomeBusca);
                req.setAttribute("listaClientes", clientes);

                String url = "/SenacToys/cliente/buscarCliente.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(req,resp);
            }catch(NullPointerException | ServletException e){
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            List<Cliente> clientes = new ArrayList<>();
            clientes = clienteFacade.buscarCliente();
            req.setAttribute("listaClientes", clientes);
        
            String url = "/SenacToys/cliente/buscarCliente.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(req.getParameter("_method").equals("post")){
            String cpf = req.getParameter("cpfCliente");
            String nome = req.getParameter("nomeCliente");
            String email = req.getParameter("emailCliente");
            String dataNascimento = req.getParameter("dataCliente");
            String telefone = req.getParameter("telefoneCliente");
            String endereco = req.getParameter("enderecoCliente");

            Cliente cliente = new Cliente();

            cliente.setCpf(cpf);
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setDataNascimento(dataNascimento);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);

            try {
                Boolean resposta = clienteFacade.cadastroCliente(cliente);
                if(resposta){
                    String sucesso = "/SenacToys/cliente/sucesso.jsp";
                    String urlVoltar = "/SenacToys/cliente/cadastro.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/cliente/erro.jsp";
                    String urlVoltar = "/SenacToys/cliente/cadastro.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
                
            } catch (IOException | ServletException e) {
                String erro = "/SenacToys/cliente/erro.jsp";
                String urlVoltar = "/SenacToys/cliente/cadastro.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                dispatcher.forward(req,resp);
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            doPut(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String cpf = req.getParameter("cpfCliente");
        String nome = req.getParameter("nomeCliente");
        String email = req.getParameter("emailCliente");
        String dataNascimento = req.getParameter("dataCliente");
        String telefone = req.getParameter("telefoneCliente");
        String endereco = req.getParameter("enderecoCliente");
        
        Cliente cliente = new Cliente();
        
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setDataNascimento(dataNascimento);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        
        try {
            Boolean resposta = clienteFacade.atualizarCliente(cliente);
            if(resposta){
                String sucesso = "/SenacToys/cliente/sucesso.jsp";
                String urlVoltar = "/SenacToys/cliente/buscarCliente.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                dispatcher.forward(req,resp);
            }else{
                String erro = "/SenacToys/cliente/erro.jsp";
                String urlVoltar = "/SenacToys/cliente/buscarCliente.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                dispatcher.forward(req,resp);
            }
            
        } catch (IOException e) {
                String erro = "/SenacToys/cliente/erro.jsp";
                String urlVoltar = "/SenacToys/cliente/buscarCliente.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                dispatcher.forward(req,resp);
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            Boolean resposta = clienteFacade.deletarCliente(req.getParameter("cpfCliente"));
            
            if(resposta){
                String sucesso = "/SenacToys/cliente/sucesso.jsp";
                String urlVoltar = "/SenacToys/cliente/buscarCliente.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                dispatcher.forward(req,resp);
            }else{
                String erro = "/SenacToys/cliente/erro.jsp";
                String urlVoltar = "/SenacToys/cliente/buscarCliente.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                dispatcher.forward(req,resp);
            }
            
        } catch (IOException | ServletException e) {
            String erro = "/SenacToys/cliente/erro.jsp";
            String urlVoltar = "/SenacToys/cliente/buscarCliente.jsp";
            req.setAttribute("urlVoltar", urlVoltar);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
            dispatcher.forward(req,resp);
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

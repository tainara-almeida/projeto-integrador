/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.entities.Funcionario;
import com.pi.facade.FuncionarioFacedImpl;
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
public class FuncionarioServlet extends HttpServlet {

    FuncionarioFacedImpl funcionarioFacade = new FuncionarioFacedImpl();
    Formatador2 formatar = new Formatador2();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeBusca = req.getParameter("nomeFuncionario");
        String cpfBusca = req.getParameter("cpfFuncionario");
        String operacao = req.getParameter("operacao");
        
        if(cpfBusca != null && !cpfBusca.equals("")){
            List<Funcionario> funcionarios = new ArrayList<>();
            Funcionario funcionario = new Funcionario();
            
            if(operacao.equals("deletar")){
                doDelete(req, resp);
            }
            
            funcionario = funcionarioFacade.buscarFuncionarioPorCpf(cpfBusca);
            funcionarios.add(funcionario);
            req.setAttribute("listaFuncionarios", funcionarios);
        
            String url = "";
            
            switch(operacao){
                case "busca":
                    url = "/SenacToys/funcionario/buscarFuncionario.jsp";
                    break;
                case "atualizar":
                    url = "/SenacToys/funcionario/atualizar.jsp";
                    break;
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
            
        }else if(nomeBusca != null && !nomeBusca.equals("")){
            try{
                List<Funcionario> funcionarios = new ArrayList<>();
                Funcionario funcionario = new Funcionario();
                funcionarios = funcionarioFacade.buscarFuncionarioPorNome(nomeBusca);
                req.setAttribute("listaFuncionarios", funcionarios);

                String url = "/SenacToys/funcionario/buscarFuncionario.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(req,resp);
            }catch(NullPointerException | ServletException e){
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            List<Funcionario> funcionarios = new ArrayList<>();
            funcionarios = funcionarioFacade.buscarFuncionarios();
            req.setAttribute("listaFuncionarios", funcionarios);
        
            String url = "/SenacToys/funcionario/buscarFuncionario.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(req.getParameter("_method").equals("post")){
            String cpf = req.getParameter("cpfFuncionario");
            String nome = req.getParameter("nomeFuncionario");
            String email = req.getParameter("emailFuncionario");
            String dataNascimento = req.getParameter("dataFuncionario");
            String telefone = req.getParameter("telefoneFuncionario");
            String endereco = req.getParameter("enderecoFuncionario");

            Funcionario funcionario = new Funcionario();

            funcionario.setCpf(cpf);
            funcionario.setNome(nome);
            funcionario.setEmail(email);
            funcionario.setDataNascimento(dataNascimento);
            funcionario.setTelefone(telefone);
            funcionario.setEndereco(endereco);

            try {
                boolean resposta  = funcionarioFacade.cadastroFuncionario(funcionario);
                
                if(resposta){
                    String sucesso = "/SenacToys/funcionario/sucesso.jsp";
                    String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/funcionario/erro.jsp";
                    String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
            } catch (IOException | ServletException e) {
                String erro = "/SenacToys/funcionario/erro.jsp";
                String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                dispatcher.forward(req,resp);
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            doPut(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String cpf = req.getParameter("cpfFuncionario");
        String nome = req.getParameter("nomeFuncionario");
        String email = req.getParameter("emailFuncionario");
        String dataNascimento = req.getParameter("dataFuncionario");
        String telefone = req.getParameter("telefoneFuncionario");
        String endereco = req.getParameter("enderecoFuncionario");

        Funcionario funcionario = new Funcionario();

        funcionario.setCpf(cpf);
        funcionario.setNome(nome);
        funcionario.setEmail(email);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setTelefone(telefone);
        funcionario.setEndereco(endereco);
        
        try {
            boolean resposta  = funcionarioFacade.atulaizarFuncionario(funcionario);
            if(resposta){
                    String sucesso = "/SenacToys/funcionario/sucesso.jsp";
                    String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/funcionario/erro.jsp";
                    String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
        } catch (IOException e) {
            String erro = "/SenacToys/funcionario/erro.jsp";
            String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
            req.setAttribute("urlVoltar", urlVoltar);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
            dispatcher.forward(req,resp);
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            boolean resposta  = funcionarioFacade.deletarFuncionario(req.getParameter("cpfFuncionario"));
            if(resposta){
                    String sucesso = "/SenacToys/funcionario/sucesso.jsp";
                    String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/funcionario/erro.jsp";
                    String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
        } catch (IOException | ServletException e) {
            String erro = "/SenacToys/funcionario/erro.jsp";
            String urlVoltar = "/SenacToys/funcionario/funcionarios.jsp";
            req.setAttribute("urlVoltar", urlVoltar);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
            dispatcher.forward(req,resp);
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
}

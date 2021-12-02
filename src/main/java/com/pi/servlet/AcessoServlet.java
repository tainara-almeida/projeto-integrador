/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.AcessoDaoImpl;
import com.pi.dao.FuncionarioDaoImpl;
import com.pi.entities.Funcionario;
import com.pi.uteis.Criptografia;
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
public class AcessoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(req.getParameter("_method").equals("post")){
            String login = req.getParameter("loginFuncionario");
            String cpf = req.getParameter("cpfFuncionario");
            String setor = req.getParameter("setorFuncionario");
            String empresaCNPJ = req.getParameter("empresaCNPF");
            String senha = Criptografia.gerarHashSenha(req.getParameter("senhaFuncionario"));
            

            try {
                boolean resposta = AcessoDaoImpl.inserirEstrutura(cpf, setor, empresaCNPJ);
                
                if(resposta){
                    boolean respostaAcesso = AcessoDaoImpl.inserirAcesso(cpf, login, senha);
                    if(respostaAcesso){
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Funcionario> listaFuncionarios = FuncionarioDaoImpl.getFuncionarios();
        req.setAttribute("listaFuncionarios", listaFuncionarios);
        
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SenacToys/funcionario/cadastroAcesso.jsp");
        requestDispatcher.forward(req, resp);
            
    }
    
    
    
}

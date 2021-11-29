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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
                boolean estruturaOk = AcessoDaoImpl.inserirEstrutura(cpf, setor, empresaCNPJ);
                
                if(estruturaOk){
                    AcessoDaoImpl.inserirAcesso(cpf, login, senha);
                }

                String url = "/SenacToys/funcionario/cadastroAcesso.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(req,resp);
            } catch (IOException | ServletException e) {
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

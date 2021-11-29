/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.AcessoDaoImpl;
import com.pi.entities.Acesso;
import com.pi.uteis.Criptografia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
public class LoginServlet extends HttpServlet {

    //Logout
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        HttpSession sessao = req.getSession();
        sessao.invalidate();
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
        
    }
    
    //Login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeUsuario = req.getParameter("nomeUsuario");
        String senhaUsuario = req.getParameter("senhaUsuario");
        
        Acesso user = AcessoDaoImpl.getUsuario(nomeUsuario);
        
        
        if(user == null){
            resp.sendRedirect(req.getContextPath() + "/login.jsp?loginInvalido=true");
        }else{
            boolean senhaOk = Criptografia.verificarSenha(senhaUsuario, user.getSenha());
            if(senhaOk){
                HttpSession sessao = req.getSession();
                sessao.setAttribute("usuario", user);
                resp.sendRedirect(req.getContextPath() + "/SenacToys/index.jsp"); 
            }else{
                resp.sendRedirect(req.getContextPath() + "/login.jsp?loginInvalido=true");
            }
        }
    }
}

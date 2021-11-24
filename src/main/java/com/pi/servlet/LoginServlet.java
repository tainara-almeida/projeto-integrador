/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.UsuarioDaoImpl;
import com.pi.entities.Usuario;
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
        
        Usuario user = UsuarioDaoImpl.getUsuario(nomeUsuario, senhaUsuario);
        
        if(user == null){
            
        }else{
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario", user);
            resp.sendRedirect(req.getContextPath() + "/SenacToys/index.jsp");
        }
    }
}

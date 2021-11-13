/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.entities.Cliente;
import com.pi.facade.ClienteFacadeImpl;
import com.pi.uteis.Formatador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andrew.dornelas
 */
@WebServlet(name = "DeletarCliente", urlPatterns = {"/DeletarCliente"})
public class DeletarCliente extends HttpServlet {
    
    Formatador formatador;
    ClienteFacadeImpl clienteFacade;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpfCliente");
        
        try{
            clienteFacade.deletarCliente(cpf);
            resp.sendRedirect(req.getContextPath()+"/uteis/sucesso.jsp");
        }catch(IOException e){
            resp.sendRedirect(req.getContextPath()+"/uteis/erro.jsp");
        }
    }
}

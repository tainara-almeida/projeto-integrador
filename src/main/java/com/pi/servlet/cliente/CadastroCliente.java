/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet.cliente;

import com.pi.dao.ClienteDao;
import com.pi.entities.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andrew.dornelas
 */

 public class CadastroCliente extends HttpServlet {

     ClienteDao clienteDao;
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nome = request.getParameter("nomeCliente");
            String email = request.getParameter("emailCliente");
            String cpf = request.getParameter("cpfCliente");
            String dataNascimento = request.getParameter("dataNascimento");
            String telefone = request.getParameter("telefoneCliente");
            String endereco = request.getParameter("enderecoCliente");
            String senha = request.getParameter("senhaCliente");
            
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setCpf(Integer.parseInt(cpf));
            cliente.setEmail(email);
            cliente.setDataNascimento(formataData(dataNascimento));
            cliente.setTelefone(Integer.parseInt(telefone));
            cliente.setEndereco(endereco);
            cliente.setSenha(senha);
            
            boolean inserirCliente = clienteDao.inserirCliente(cliente);
            if(inserirCliente){
                response.sendRedirect(request.getContextPath()+"/uteis/sucesso.jsp");
            }
        } catch(ParseException ex) {
             response.sendRedirect(request.getContextPath()+"/uteis/erro.jsp");
        } catch (SQLException ex) {
             Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpfUsuario");
        String operacao = req.getParameter("ope");
            clienteDao.deletarCliente(cpf);
            resp.sendRedirect(req.getContextPath() + "/cliente/ListarClienteServlet");
        


    }
    
    public Date formataData(String data) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(data);
        return dataFormatada;
    }
}

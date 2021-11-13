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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andrew.dornelas
 */

 public class CadastroCliente extends HttpServlet {

     ClienteFacadeImpl clienteFacade;
     Formatador formatador = new Formatador();
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String nome = request.getParameter("nomeCliente");
        String email = request.getParameter("emailCliente");
        String cpf = request.getParameter("cpfCliente");
        String dataNascimento = request.getParameter("dataNascimento");
        String telefone = request.getParameter("telefoneCliente");
        String endereco = request.getParameter("enderecoCliente");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setDataNascimento(formatador.formataStringParaData(dataNascimento));
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);

        try{
            clienteFacade.cadastroCliente(cliente);
            response.sendRedirect(request.getContextPath()+"/uteis/sucesso.jsp");
        }catch(IOException e){
            response.sendRedirect(request.getContextPath()+"/uteis/erro.jsp");
        }
    }
}

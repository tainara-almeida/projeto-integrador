/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.dao.ClienteDaoImpl;
import com.pi.entities.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class ClienteFacadeImpl implements ClienteFacade{
    
    @Override
    public Boolean cadastroCliente(Cliente filtro){
        Boolean resposta = false;
        try{   
            ClienteDaoImpl.inserirCliente(filtro);
            resposta = true;
        }catch(Exception e){
            resposta = false;
           Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return resposta;
    }
    
    @Override
    public Boolean atualizarCliente(Cliente cliente){
        Boolean resposta = false;
        try{
            ClienteDaoImpl.atualizarCliente(cliente);
            resposta = true;
        }catch(Exception e){
            resposta = false;
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return resposta;
    }
    
    @Override
    public Boolean deletarCliente(String cpf){
        Boolean resposta = false;
        try{
            ClienteDaoImpl.deletarCliente(cpf);
            resposta = true;
        }catch(Exception e){
            resposta = false;
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return resposta;
    }
    
    @Override
    public List<Cliente> buscarClientePorNome(String nome) {
        try{
            return ClienteDaoImpl.getClientePorNome(nome);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        try{
            return ClienteDaoImpl.getClientePorCPF(cpf);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public List<Cliente> buscarCliente() {
        try{
            return ClienteDaoImpl.getClientes();
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    
}

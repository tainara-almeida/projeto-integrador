/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.dao.ClienteDaoImpl;
import com.pi.entities.Cliente;
import com.pi.uteis.Formatador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class ClienteFacadeImpl{
    
    Formatador formatador = new Formatador();
    
    public void cadastroCliente(Cliente filtro){
        try{   
            ClienteDaoImpl.inserirCliente(filtro);
        }catch(Exception e){
           Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void atulaizarCliente(Cliente cliente){
        try{
            ClienteDaoImpl.atualizarCliente(cliente);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deletarCliente(String cpf){
        try{
            ClienteDaoImpl.deletarCliente(cpf);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public List<Cliente> buscarClientePorNome(String nome) {
        try{
            return ClienteDaoImpl.getClientePorNome(nome);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        try{
            return ClienteDaoImpl.getClientePorCPF(cpf);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Cliente> buscarCliente() {
        try{
            return ClienteDaoImpl.getClientes();
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.dao.ClienteDao;
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
    
    ClienteDaoImpl clienteDao = new ClienteDaoImpl();
    
    public final String CLIENTE_EXISTENTE = "Cliente ja existe";
    
    public final String CPF_INVALIDO = "Favor fornecer um cpf valido";
    public final String TELEFONE_INVALIDO = "Favor fornecer um telefone valido";
    public final String NOME_INVALIDO = "Favor fornecer um nome valido";
    public final String ENDERECO_INVALIDO = "Favor fornecer um endereço valido";
    public final String EMAIL_INVALIDO = "Favor fornecer um email valido";
    public final String DATA_NASCIMENTO_INVALIDO = "Favor fornecer uma data de nascimento valida";
    
    Formatador formatador = new Formatador();
    
    public void cadastroCliente(Cliente filtro){
        Cliente cliente = new Cliente();
        try{
            if(!filtro.getCpf().equals(null) && !filtro.getCpf().equals("")){
            cliente.setCpf(formatador.formataCPF(filtro.getCpf()));
            }else{
                throw new Exception(CPF_INVALIDO);
            }
            if(!filtro.getTelefone().equals(null) && !filtro.getTelefone().equals("")){
                cliente.setTelefone(formatador.formataTelefone(filtro.getTelefone()));
            }else{
                throw new Exception(TELEFONE_INVALIDO);
            }
            if(!filtro.getDataNascimento().equals(null) && !filtro.getDataNascimento().equals("")){
                cliente.setDataNascimento(filtro.getDataNascimento());
            }else{
                throw new Exception(DATA_NASCIMENTO_INVALIDO);
            }
            if(!filtro.getEmail().equals(null) && !filtro.getEmail().equals("")){
                cliente.setEmail(filtro.getEmail());
            }else{
                throw new Exception(EMAIL_INVALIDO);
            }
            if(!filtro.getEndereco().equals(null) && !filtro.getEndereco().equals("")){
                cliente.setEndereco(filtro.getEndereco());
            }else{
                throw new Exception(ENDERECO_INVALIDO);
            }
            if(!filtro.getNome().equals(null) && !filtro.getNome().equals("")){
                cliente.setNome(filtro.getNome());
            }else{
                throw new Exception(NOME_INVALIDO);
            }
            
            if(validaClienteExistente(formatador.formataCPF(filtro.getCpf()))){
                clienteDao.inserirCliente(cliente);
            }else{
                throw new Exception(CLIENTE_EXISTENTE);
            }
        }catch(Exception e){
           Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deletarCliente(String cpf){
        String filtroCpf = formatador.formataCPF(cpf);
        try{
            if(validaClienteExistente(filtroCpf)){
                clienteDao.deletarCliente(filtroCpf);
            }else{
                throw new Exception(CPF_INVALIDO);
            }
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public List<Cliente> buscarClientePorNome(String nome) {
        try{
            return clienteDao.getClientePorNome(nome);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        String filtroCpf = formatador.formataCPF(cpf);
        try{
            return clienteDao.getClientePorCPF(filtroCpf);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Cliente> buscarCliente() {
        try{
            return clienteDao.getClientes();
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    private boolean validaClienteExistente(String cpf){
        boolean retorno;
        if(clienteDao.getClientePorCPF(cpf) != null){
            return retorno = false;
        }else{
            return retorno = true;
        }
    }

    
}
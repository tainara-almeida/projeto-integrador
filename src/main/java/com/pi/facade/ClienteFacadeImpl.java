/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.dao.ClienteDao;
import com.pi.entities.Cliente;
import com.pi.uteis.Formatador;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class ClienteFacadeImpl implements ClienteFacade{
    
    ClienteDao clienteDao;
    
    private static final com.sun.org.slf4j.internal.Logger LOGGER = LoggerFactory.getLogger(ClienteFacadeImpl.class);
    
    public final String CPF_INVALIDO = "Favor fornecer um cpf valido";
    public final String TELEFONE_INVALIDO = "Favor fornecer um telefone valido";
    public final String NOME_INVALIDO = "Favor fornecer um nome valido";
    public final String ENDERECO_INVALIDO = "Favor fornecer um endereço valido";
    public final String EMAIL_INVALIDO = "Favor fornecer um email valido";
    public final String DATA_NASCIMENTO_INVALIDO = "Favor fornecer uma data de nascimento valida";
    
    Formatador formatador = new Formatador();
    
    @Override
    public boolean cadastroCliente(Cliente filtro){
        Cliente cliente = new Cliente();
        boolean inserirCliente;
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
            
            inserirCliente = clienteDao.inserirCliente(cliente);
        }catch(Exception e){
            inserirCliente = false;
           LOGGER.error("Erro:", e);
        }
        return inserirCliente;
    }
    
    
    
}

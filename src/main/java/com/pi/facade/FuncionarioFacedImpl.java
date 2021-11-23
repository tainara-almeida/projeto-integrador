/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.dao.FuncionarioDaoImpl;
import com.pi.entities.Funcionario;
import com.pi.uteis.Formatador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class FuncionarioFacedImpl {
    
    Formatador formatador = new Formatador();
    
    public void cadastroFuncionario(Funcionario filtro){
        try{   
            FuncionarioDaoImpl.inserirFuncionario(filtro);
        }catch(Exception e){
           Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void atulaizarFuncionario(Funcionario funcionario){
        try{
            FuncionarioDaoImpl.atualizarFuncionario(funcionario);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deletarFuncionario(String cpf){
        try{
            FuncionarioDaoImpl.deletarFuncionario(cpf);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public List<Funcionario> buscarFuncionarioPorNome(String nome) {
        try{
            return FuncionarioDaoImpl.getFuncionarioPorNome(nome);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        try{
            return FuncionarioDaoImpl.getFuncionarioPorCPF(cpf);
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Funcionario> buscarFuncionarios() {
        try{
            return FuncionarioDaoImpl.getFuncionarios();
        }catch(Exception e){
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}

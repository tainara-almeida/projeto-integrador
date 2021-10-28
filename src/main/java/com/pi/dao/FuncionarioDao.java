/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.entities.Funcionario;
import java.util.List;

/**
 *
 * @author Andrew
 */
public interface FuncionarioDao {
    public void inserirFuncionario(Funcionario funcionario);
    public List<Funcionario> getFuncionario();
    public Funcionario getFuncionarioPorCPF(String cpf);
    public List<Funcionario> getFuncionarioPorNome(String nomeBusca);
    public void deletarFuncionario(String cpf);
    public boolean atualizarFuncionario(Funcionario funcionario);
    
}

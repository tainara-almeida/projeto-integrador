/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.entities.Cliente;
import java.util.List;

/**
 *
 * @author Andrew
 */
public interface ClienteFacade {
     public Boolean cadastroCliente(Cliente filtro);
     public Boolean atualizarCliente(Cliente cliente);
     public Boolean deletarCliente(String cpf);
     public List<Cliente> buscarClientePorNome(String nome);
     public Cliente buscarClientePorCpf(String cpf);
     public List<Cliente> buscarCliente();
}

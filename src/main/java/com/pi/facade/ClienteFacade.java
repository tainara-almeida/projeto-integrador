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
    void cadastroCliente(Cliente filtro);
    void deletarCliente(String cpf);
    List<Cliente> buscarClientePorNome(String nome);
    Cliente buscarClientePorCpf(String cpf);
    List<Cliente> buscarCliente();
}

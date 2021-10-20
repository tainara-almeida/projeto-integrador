/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.entities.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Andrew
 */
public interface ClienteDao {
    boolean inserirCliente(Cliente cliente) throws SQLException;
    List<Cliente> getClientes();
    Cliente getClientePorCPF(Integer cpf);
    List<Cliente> getClientePorNome(String nomeBusca);
    boolean deletarCliente(String cpf);
    boolean atualizarCliente(Cliente cliente);
}

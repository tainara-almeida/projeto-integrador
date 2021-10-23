/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.facade;

import com.pi.entities.Cliente;

/**
 *
 * @author Andrew
 */
public interface ClienteFacade {
    public boolean cadastroCliente(Cliente filtro);
}

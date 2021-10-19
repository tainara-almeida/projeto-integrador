/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import com.pi.enuns.StatusVenda;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author andrew.dornelas
 */
@Getter
@Setter
public class Venda implements Serializable{
    private Long id;
    private Date dataVenda;
    private StatusVenda statusvenda;
    private Cliente cliente;
    private List<Pedido> pedido;
    
    public Double totalVenda(){
        double total = 0;
        for(Pedido pedidos : this.pedido){
            total += pedidos.vatorTotalPedido();
        }
        return total;
    }
}

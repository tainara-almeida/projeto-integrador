/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author andrew.dornelas
 */
@Getter
@Setter
public class Pedido implements Serializable{
    private Long id;
    private List<ItemPedido> itensPedido;
    
    public Double vatorTotalPedido(){
        double total = 0;
        for(ItemPedido itens : this.itensPedido){
            total += itens.subTotal();
        }
        return total;
    }
}

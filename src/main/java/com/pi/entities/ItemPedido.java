/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author andrew.dornelas
 */
@Getter
@Setter
public class ItemPedido implements Serializable{
    private Integer quantidade;
    private Double preco;
    
    public Double subTotal(){
        return this.preco * this.quantidade;
    }
}

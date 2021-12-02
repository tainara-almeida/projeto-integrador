/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andrew
 */
@Getter
@Setter
public class Carrinho {
    private int codProduto;
    private String nomeProduto;
    private Double precoProduto;
}

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
public class Relatorio {
    private int codRelatorio;
    private int codVenda;
    private int codCliente;
    private int codPedido;
    private int codProduto;
    private String nomeCliente;
    private double valorTotalVenda;
    private String dataVenda;
    private double totalPedido;
    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;
}

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
public class Produto implements Serializable{
    private int codProduto;
    private int quantidade;
    private String categoria;
    private String nome;
    private String descricao;
    private String classificacaoIdade;
    private Double precoUnitario;
    private String imgUrl;
}

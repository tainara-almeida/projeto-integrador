/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author andrew.dornelas
 */
@Getter
@Setter
public class Cliente implements Serializable{
    private Integer id;
    private Integer cpf;
    private String nome;
    private String email;
    private Date dataNascimento;
    private Integer telefone;
    private Endereco endereco;
    private String senha;
}
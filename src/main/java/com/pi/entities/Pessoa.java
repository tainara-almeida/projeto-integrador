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
public abstract class Pessoa {
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;
    private String telefone;
    private String endereco;
}

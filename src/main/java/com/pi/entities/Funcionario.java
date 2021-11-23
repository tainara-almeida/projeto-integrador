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
public class Funcionario implements Serializable{
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;
    private String telefone;
    private String endereco;
    private String senha;
}

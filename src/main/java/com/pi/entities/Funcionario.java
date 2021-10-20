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
public class Funcionario implements Serializable{
    private Long id;
    private Long cpf;
    private Long codigoEmpresa;
    private String nome;
    private String email;
    private Date dataNascimento;
    private Long telefone;
    private String endereco;
    private Setor setor;
    private String senha;
}

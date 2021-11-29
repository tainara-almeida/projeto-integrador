/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andrew
 */
@Getter
@Setter
public class Acesso implements Serializable{
    
    private int codEstrutura;
    private String setor;
    private String nome;
    private String senha;
    
    public boolean isAdmin(){
        return "ADMINISTRACAO".equalsIgnoreCase(this.setor);
    }
    
    public boolean isSeller(){
        return "VENDAS".equalsIgnoreCase(this.setor);
    }
    
    public boolean isManager(){
        return "GERENCIA".equalsIgnoreCase(this.setor);
    }
}

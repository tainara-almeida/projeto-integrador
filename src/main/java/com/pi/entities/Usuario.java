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
 * @author Andrew
 */
@Getter
@Setter
public class Usuario implements Serializable{
    
    private Integer id;
    private String login;
    private String nome;
    private String perfil;
    
    public boolean isAdmin(){
        return "Admin".equalsIgnoreCase(this.perfil);
    }
}

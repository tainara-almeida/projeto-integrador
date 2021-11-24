/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class UsuarioDaoImpl {
    
    public static Usuario getUsuario(String login, String senha){
       
        Connection con = Conexao.getConexao();
        Usuario user = null;
        
        String query = "SELECT * FROM USUARIO WHERE LOGIN=? AND SENHA=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Integer id = rs.getInt("COD_USUARIO");
                String nome = rs.getString("NOME");
                String perfil = rs.getString("PERFIL");
                user = new Usuario();
                user.setId(id);
                user.setLogin(login);
                user.setNome(nome);
                user.setPerfil(perfil);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    
}

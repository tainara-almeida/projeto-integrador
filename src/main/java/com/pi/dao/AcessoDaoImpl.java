/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Acesso;
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
public class AcessoDaoImpl {
    
    public static Acesso getUsuario(String login, String senha){
       
        Connection con = Conexao.getConexao();
        Acesso user = null;
        
        String query = "SELECT A.COD_ESTRUTURA, B.NM_FUNCIONARIO, C.NM_SETOR, D.DC_LOGIN FROM ESTRUTURA A " +
                        "INNER JOIN FUNCIONARIO B " +
                        "ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO " +
                        "INNER JOIN SETOR C " +
                        "ON A.COD_SETOR = C.COD_SETOR " +
                        "INNER JOIN ACESSO D " +
                        "ON A.COD_ESTRUTURA = D.COD_ESTRUTURA " +
                        "WHERE D.DC_LOGIN = ? AND D.DC_SENHA = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Integer codEstrutura = rs.getInt("COD_ESTRUTURA");
                String nome = rs.getString("NM_FUNCIONARIO");
                String setor = rs.getString("NM_SETOR");
                user = new Acesso();
                user.setCodEstrutura(codEstrutura);
                user.setSetor(setor);
                user.setNome(nome);
            }
        } catch (SQLException e) {
            Logger.getLogger(AcessoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    
}

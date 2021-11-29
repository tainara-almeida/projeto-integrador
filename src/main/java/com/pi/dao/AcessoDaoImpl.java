/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Acesso;
import com.pi.entities.Funcionario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
    
    public static Acesso getUsuario(String login){
       
        Connection con = Conexao.getConexao();
        Acesso user = null;
        
        String query = "SELECT A.COD_ESTRUTURA, B.NM_FUNCIONARIO, C.NM_SETOR, D.DC_LOGIN, D.DC_SENHA FROM ESTRUTURA A " +
                        "INNER JOIN FUNCIONARIO B " +
                        "ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO " +
                        "INNER JOIN SETOR C " +
                        "ON A.COD_SETOR = C.COD_SETOR " +
                        "INNER JOIN ACESSO D " +
                        "ON A.COD_ESTRUTURA = D.COD_ESTRUTURA " +
                        "WHERE D.DC_LOGIN = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Integer codEstrutura = rs.getInt("COD_ESTRUTURA");
                String nome = rs.getString("NM_FUNCIONARIO");
                String setor = rs.getString("NM_SETOR");
                String senha = rs.getString("DC_SENHA");
                user = new Acesso();
                user.setCodEstrutura(codEstrutura);
                user.setSetor(setor);
                user.setNome(nome);
                user.setSenha(senha);
            }
        } catch (SQLException e) {
            Logger.getLogger(AcessoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    
    static public void inserirAcesso(String cpf, String login, String senha){
        Connection con = Conexao.getConexao();
        
        try{
            String queryCadastroFuncionario = "INSERT INTO ACESSO(COD_ESTRUTURA, DC_LOGIN, DC_SENHA) \n" +
                                                "VALUES (" +
                                                "(SELECT A.COD_ESTRUTURA FROM ESTRUTURA A " +
                                                "INNER JOIN FUNCIONARIO B " +
                                                "ON A.COD_FUNCIONARIO = B.COD_FUNCIONARIO " +
                                                "INNER JOIN SETOR C " +
                                                "ON A.COD_SETOR = C.COD_SETOR " +
                                                "INNER JOIN EMPRESA D " +
                                                "ON A.COD_EMPRESA = D.COD_EMPRESA " +
                                                "WHERE B.DC_CPF = ?), ?, ?);";
            PreparedStatement ps;
            ps = con.prepareCall(queryCadastroFuncionario);
            ps.setString(1, cpf);
            ps.setString(2, login);
            ps.setString(3, senha);
            ps.execute();
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static public boolean inserirEstrutura(String cpf, String setor, String empresaCNPJ){
        Connection con = Conexao.getConexao();
        boolean cadastrado = false;
        
        try{
            String queryCadastroFuncionario = "CALL SPI_ESTRUTURA(" +
                                                "(SELECT COD_EMPRESA FROM EMPRESA WHERE DC_CNPJ = ?), " +
                                                "(SELECT COD_SETOR FROM SETOR WHERE NM_SETOR = ?), " +
                                                "(SELECT COD_FUNCIONARIO FROM FUNCIONARIO WHERE DC_CPF = ?));";
            CallableStatement ps;
            ps = con.prepareCall(queryCadastroFuncionario);
            ps.setString(1, empresaCNPJ);
            ps.setString(2, setor);
            ps.setString(3, cpf);
            ps.execute();
            cadastrado = true;
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadastrado;
    }
    
    
    
}

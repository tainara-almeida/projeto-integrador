/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Cliente;
import com.pi.entities.Funcionario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class FuncionarioDaoImpl{
    
    static public void inserirFuncionario(Funcionario funcionario){
        String query = "CALL SPI_FUNCIONARIO(?, ?, ?, ?, ?, ?);";
        Connection con = Conexao.getConexao();
        
        try{
            CallableStatement ps;
            ps = con.prepareCall(query);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEmail());
            ps.setDate(4, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(5, funcionario.getTelefone());
            ps.setString(6, funcionario.getEndereco());
            ps.execute();
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "select * from Funcionario";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                String nome = rs.getString("NM_FUNCIONARIO");
                String email = rs.getString("DC_EMAIL");
                String cpf = rs.getString("DC_CPF");
                Integer id = rs.getInt("COD_FUNCIONARIO");
                String dataNascimento = rs.getString("DT_NASCIMENTO");
                String telefone = rs.getString("DC_TELEFONE");
                String endereco = rs.getString("DC_ENDERECO");
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setDataNascimento(dataNascimento);
                funcionario.setId(id);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    static public Funcionario getFuncionarioPorCPF(String cpfFun) {
        String query = "select * from funcionario where DC_CPF=?";
        Connection con = Conexao.getConexao();
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpfFun);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null && rs.next()){
                funcionario = new Funcionario();
                String nome = rs.getString("NM_FUNCIONARIO");
                String email = rs.getString("DC_EMAIL");
                Integer id = rs.getInt("COD_FUNCIONARIO");
                String cpf = rs.getString("DC_CPF");
                String dataNascimento = rs.getString("DT_NASCIMENTO");
                String telefone = rs.getString("DC_TELEFONE");
                String endereco = rs.getString("DC_ENDERECO");
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setDataNascimento(dataNascimento);
                funcionario.setId(id);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    static public List<Funcionario> getFuncionarioPorNome(String nomeBusca) {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "select * from Funcionario where NM_FUNCIONARIO like ?";

        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                String nome = rs.getString("NM_FUNCIONARIO");
                String email = rs.getString("DC_EMAIL");
                Integer id = rs.getInt("COD_FUNCIONARIO");
                String cpf = rs.getString("DC_CPF");
                String dataNascimento = rs.getString("DT_NASCIMENTO");
                String telefone = rs.getString("DC_TELEFONE");
                String endereco = rs.getString("DC_ENDERECO");
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setDataNascimento(dataNascimento);
                funcionario.setId(id);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco);
                funcionarios.add(funcionario);
            }
            return funcionarios;
        } catch (SQLException ex) {
            funcionarios = null;
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    static public void deletarFuncionario(String cpf) {
        String query = "delete from Funcionario where DC_CPF=?;";
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, cpf);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    static public boolean atualizarFuncionario(Funcionario funcionario) {
        boolean ok = true;
        String query = "UPDATE FUNCIONARIO SET NM_FUNCIONARIO=?, DC_EMAIL=?, DT_NASCIMENTO=?, DC_TELEFONE=?, DC_ENDERECO=? where DC_CPF=?;";
        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getEndereco());
            ps.setString(6, funcionario.getCpf());
            ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
         return ok;
    }
}

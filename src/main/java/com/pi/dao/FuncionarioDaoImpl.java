/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Funcionario;
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
public class FuncionarioDaoImpl implements FuncionarioDao{
    
    @Override
    public void inserirFuncionario(Funcionario funcionario){
        String query = "insert into funcionario(nome, cpf, email, dataNascimento, telefone) values (?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        
        try{
            PreparedStatement ps;
            ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEmail());
            ps.setDate(4, (Date) funcionario.getDataNascimento());
            ps.setString(5, funcionario.getTelefone());
            ps.execute();
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Funcionario> getFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "select * from funcionario";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                Integer id = rs.getInt("id");
                Date dataNascimento = rs.getDate("dataNascimento");
                String telefone = rs.getString("telefone");
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setDataNascimento(dataNascimento);
                funcionario.setId(id);
                funcionario.setTelefone(telefone);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;

    }

    @Override
    public Funcionario getFuncionarioPorCPF(String cpf) {
        String query = "select * from funcionario where cpf=?";
        Funcionario funcionario = null;
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Integer id = rs.getInt("id");
                Date dataNascimento = rs.getDate("dataNascimento");
                String telefone = rs.getString("telefone");
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setDataNascimento(dataNascimento);
                funcionario.setId(id);
                funcionario.setTelefone(telefone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;

    }

    @Override
    public List<Funcionario> getFuncionarioPorNome(String nomeBusca) {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "select * from funcionario where nome like ?";

        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Integer id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("dataNascimento");
                String telefone = rs.getString("telefone");
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setDataNascimento(dataNascimento);
                funcionario.setId(id);
                funcionario.setTelefone(telefone);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;

    }

    @Override
    public void deletarFuncionario(String cpf) {
        String query = "delete from funcionario where cpf=?";
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, cpf);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public boolean atualizarFuncionario(Funcionario funcionario) {
        boolean ok = true;
        String query = "update funcionario set nome=?,email=? where cpf=?";
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, funcionario.getNome());
             ps.setString(2, funcionario.getEmail());
             ps.setString(3, funcionario.getCpf());
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
         return ok;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Scarton
 */
public class ClienteDaoImpl implements ClienteDao {
        
    @Override
    public boolean inserirCliente(Cliente cliente){
        boolean ok = true;
        String query = "insert into cliente(nome, cpf, email, dataNascimento, telefone) values (?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        
        try{
            PreparedStatement ps;
            ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setDate(4, (Date) cliente.getDataNascimento());
            ps.setString(5, cliente.getTelefone());
            ps.execute();
        }catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                Integer id = rs.getInt("id");
                Date dataNascimento = rs.getDate("dataNascimento");
                String telefone = rs.getString("telefone");
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setDataNascimento(dataNascimento);
                cliente.setId(id);
                cliente.setTelefone(telefone);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }

    @Override
    public Cliente getClientePorCPF(String cpf) {
        String query = "select * from cliente where cpf=?";
        Cliente cliente = null;
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Integer id = rs.getInt("id");
                Date dataNascimento = rs.getDate("dataNascimento");
                String telefone = rs.getString("telefone");
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setDataNascimento(dataNascimento);
                cliente.setId(id);
                cliente.setTelefone(telefone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }

    @Override
    public List<Cliente> getClientePorNome(String nomeBusca) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente where nome like ?";

        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Integer id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("dataNascimento");
                String telefone = rs.getString("telefone");
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setDataNascimento(dataNascimento);
                cliente.setId(id);
                cliente.setTelefone(telefone);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }

    @Override
    public boolean deletarCliente(String cpf) {
        boolean ok = true;
        String query = "delete from cliente where cpf=?";
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, cpf);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
         return ok;
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        boolean ok = true;
        String query = "update cliente set nome=?,email=? where cpf=?";
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, cliente.getNome());
             ps.setString(2, cliente.getEmail());
             ps.setString(3, cliente.getCpf());
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
         return ok;
    }
}
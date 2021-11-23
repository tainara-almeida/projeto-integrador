/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Cliente;
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
 * @author Tiago Scarton
 */
public class ClienteDaoImpl{
    
    static public void inserirCliente(Cliente cliente){
        String query = "CALL SPI_CLIENTE(?, ?, ?, ?, ?, ?);";
        Connection con = Conexao.getConexao();
        
        try{
            CallableStatement ps;
            ps = con.prepareCall(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setDate(4, Date.valueOf(cliente.getDataNascimento()));
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getEndereco());
            ps.execute();
        }catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public List<Cliente> getClientes() {
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
                String dataNascimento = rs.getString("DT_NASCIMENTO");
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

    static public Cliente getClientePorCPF(String cpfCli) {
        String query = "select * from CLIENTE where DC_CPF=?";
        Connection con = Conexao.getConexao();
        Cliente cliente = new Cliente();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpfCli);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null && rs.next()){
                cliente = new Cliente();
                String nome = rs.getString("NM_CLIENTE");
                String email = rs.getString("DC_EMAIL");
                Integer id = rs.getInt("COD_CLIENTE");
                String cpf = rs.getString("DC_CPF");
                String dataNascimento = rs.getString("DT_NASCIMENTO");
                String telefone = rs.getString("DC_TELEFONE");
                String endereco = rs.getString("DC_ENDERECO");
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setDataNascimento(dataNascimento);
                cliente.setId(id);
                cliente.setTelefone(telefone);
                cliente.setEndereco(endereco);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }

    static public List<Cliente> getClientePorNome(String nomeBusca) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from CLIENTE where NM_CLIENTE like ?";

        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                String nome = rs.getString("NM_CLIENTE");
                String email = rs.getString("DC_EMAIL");
                Integer id = rs.getInt("COD_CLIENTE");
                String cpf = rs.getString("DC_CPF");
                String dataNascimento = rs.getString("DT_NASCIMENTO");
                String telefone = rs.getString("DC_TELEFONE");
                String endereco = rs.getString("DC_ENDERECO");
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setDataNascimento(dataNascimento);
                cliente.setId(id);
                cliente.setTelefone(telefone);
                cliente.setEndereco(endereco);
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            clientes = null;
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }

    static public void deletarCliente(String cpf) {
        String query = "delete from CLIENTE where DC_CPF=?;";
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, cpf);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    static public boolean atualizarCliente(Cliente cliente) {
        boolean ok = true;
        String query = "UPDATE CLIENTE SET NM_CLIENTE=?, DC_EMAIL=?, DT_NASCIMENTO=?, DC_TELEFONE=?, DC_ENDERECO=? where DC_CPF=?;";
        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getCpf());
            ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
         return ok;
    }
}
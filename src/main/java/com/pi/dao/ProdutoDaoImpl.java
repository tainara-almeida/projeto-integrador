/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Funcionario;
import com.pi.entities.Produto;
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
public class ProdutoDaoImpl {
    
    static public void inserirProduto(Produto produto){
        Connection con = Conexao.getConexao();
        
        try{
            String queryCadastroProduto = "CALL SPI_PRODUTO(?, ?, ?, ?, ?, ?);";
            CallableStatement ps;
            ps = con.prepareCall(queryCadastroProduto);
            ps.setString(1, produto.getCategoria());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());
            ps.setString(4, produto.getClassificacaoIdade());
            ps.setDouble(5, produto.getPrecoUnitario());
            ps.setString(6, produto.getImgUrl());
            ps.execute();
            Conexao.fecharConexao();
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM PRODUTO;";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                int codProduto = rs.getInt("COD_PRODUTO");
                String nome = rs.getString("NM_PRODUTO");
                String categoria = rs.getString("DC_CATEGORIA_PRODUTO");
                String descricao = rs.getString("DC_PRODUTO");
                String classificacao = rs.getString("DC_CLASSIFICACAO_IDADE");
                Double precoUnitario = rs.getDouble("VL_PRECO_UNITARIO");
                String img = rs.getString("DC_IMG_URL");
                produto.setCodProduto(codProduto);
                produto.setNome(nome);
                produto.setCategoria(categoria);
                produto.setDescricao(descricao);
                produto.setClassificacaoIdade(classificacao);
                produto.setPrecoUnitario(precoUnitario);
                produto.setImgUrl(img);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    static public List<Produto> getProdutosCategoria(String categoriaProduto) {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM PRODUTO WHERE DC_CATEGORIA_PRODUTO LIKE ?;";
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + categoriaProduto + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                int codProduto = rs.getInt("COD_PRODUTO");
                String nome = rs.getString("NM_PRODUTO");
                String descricao = rs.getString("DC_PRODUTO");
                String categoria = rs.getString("DC_CATEGORIA_PRODUTO");
                String classificacao = rs.getString("DC_CLASSIFICACAO_IDADE");
                Double precoUnitario = rs.getDouble("VL_PRECO_UNITARIO");
                String img = rs.getString("DC_IMG_URL");
                produto.setCodProduto(codProduto);
                produto.setNome(nome);
                produto.setCategoria(categoria);
                produto.setDescricao(descricao);
                produto.setClassificacaoIdade(classificacao);
                produto.setPrecoUnitario(precoUnitario);
                produto.setImgUrl(img);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    static public List<Produto> getProdutosNome(String nomeProduto) {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM PRODUTO WHERE NM_PRODUTO LIKE ?;";
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + nomeProduto + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                int codProduto = rs.getInt("COD_PRODUTO");
                String nome = rs.getString("NM_PRODUTO");
                String descricao = rs.getString("DC_PRODUTO");
                String categoria = rs.getString("DC_CATEGORIA_PRODUTO");
                String classificacao = rs.getString("DC_CLASSIFICACAO_IDADE");
                Double precoUnitario = rs.getDouble("VL_PRECO_UNITARIO");
                String img = rs.getString("DC_IMG_URL");
                produto.setCodProduto(codProduto);
                produto.setNome(nome);
                produto.setCategoria(categoria);
                produto.setDescricao(descricao);
                produto.setClassificacaoIdade(classificacao);
                produto.setPrecoUnitario(precoUnitario);
                produto.setImgUrl(img);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    static public Produto getProdutoCodigo(int cod) {
        String query = "SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?;";
        
        Connection con = Conexao.getConexao();
        Produto produto = new Produto();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                int codProduto = rs.getInt("COD_PRODUTO");
                String nome = rs.getString("NM_PRODUTO");
                String descricao = rs.getString("DC_PRODUTO");
                String categoria = rs.getString("DC_CATEGORIA_PRODUTO");
                String classificacao = rs.getString("DC_CLASSIFICACAO_IDADE");
                Double precoUnitario = rs.getDouble("VL_PRECO_UNITARIO");
                String img = rs.getString("DC_IMG_URL");
                produto.setCodProduto(codProduto);
                produto.setNome(nome);
                produto.setCategoria(categoria);
                produto.setDescricao(descricao);
                produto.setClassificacaoIdade(classificacao);
                produto.setPrecoUnitario(precoUnitario);
                produto.setImgUrl(img);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
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

    static public boolean atualizarProduto(Produto produto) {
        boolean ok = true;
        String query = "UPDATE PRODUTO SET DC_CATEGORIA_PRODUTO=?, NM_PRODUTO=?, DC_PRODUTO=?, DC_CLASSIFICACAO_IDADE=?, VL_PRECO_UNITARIO=?, DC_IMG_URL=?  WHERE COD_PRODUTO=?;";
        Connection con = Conexao.getConexao();
         try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getCategoria());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());
            ps.setString(4, produto.getClassificacaoIdade());
            ps.setDouble(5, produto.getPrecoUnitario());
            ps.setString(6, produto.getImgUrl());
            ps.setInt(7, produto.getCodProduto());
            ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
         return ok;
    }
}

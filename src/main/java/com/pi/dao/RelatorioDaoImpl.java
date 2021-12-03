/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Relatorio;
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
public class RelatorioDaoImpl {
    public static List<Relatorio> buscarRelatorios(String dataInicio, String dataFim){
        String query = "SELECT * FROM RELATORIO WHERE DT_VENDA BETWEEN ? AND ?;";
        Connection con = Conexao.getConexao();
        List<Relatorio> listaRelatorio = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataInicio));
            ps.setDate(2, Date.valueOf(dataFim));
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Relatorio relatorio = new Relatorio();
                int codRelatorio = rs.getInt("COD_RELATORIO");
                int codVenda = rs.getInt("COD_VENDA");
                int codCliente = rs.getInt("COD_CLIENTE");
                int codPedido = rs.getInt("COD_PEDIDO");
                int codProduto = rs.getInt("COD_PRODUTO");
                String nomeCliente = rs.getString("NM_CLIENTE");
                double valorTotalVenda = rs.getDouble("VL_TOTAL_VENDA");
                String dataVenda = rs.getString("DT_VENDA");
                String nomeProduto = rs.getString("NM_PRODUTO");
                int quantidade = rs.getInt("NR_QUANTIDADE");
                double valorUnitario = rs.getDouble("VL_PRECO_UNITARIO");
                
                relatorio.setCodCliente(codCliente);
                relatorio.setCodPedido(codPedido);
                relatorio.setCodProduto(codProduto);
                relatorio.setCodRelatorio(codRelatorio);
                relatorio.setCodVenda(codVenda);
                relatorio.setDataVenda(dataVenda);
                relatorio.setNomeCliente(nomeCliente);
                relatorio.setNomeProduto(nomeProduto);
                relatorio.setValorTotalVenda(valorTotalVenda);
                relatorio.setPrecoUnitario(valorUnitario);
                relatorio.setQuantidade(quantidade);
                
                listaRelatorio.add(relatorio);
            }
        
        } catch (SQLException ex) {
            listaRelatorio = null;
            Logger.getLogger(RelatorioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRelatorio;
    }
}

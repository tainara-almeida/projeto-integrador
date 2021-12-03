/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.dao;

import com.pi.conexao.Conexao;
import com.pi.entities.Produto;
import com.pi.entities.Venda;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */

/*
IN PAR_COD_CLIENTE INT,
    IN PAR_DT_VENDA DATE,
    IN PAR_COD_PRODUTO INT,
    IN PAR_NR_QUANTIDADE INT
*/

public class VendaDaoImpl {
    static public boolean inserirVenda(Venda venda){
        Connection con = Conexao.getConexao();
        boolean resposta = false;
        try{
            String queryCadastroProduto = "call SPI_NOVA_VENDA(?, ?, ?, ?);";
            CallableStatement ps;
            ps = con.prepareCall(queryCadastroProduto);
            ps.setInt(1, venda.getCodCliente());
            ps.setDate(2, Date.valueOf(venda.getDataVenda()));
            ps.setInt(3, venda.getCodProduto());
            ps.setInt(4, venda.getQuantidade());
            ps.execute();
            resposta = true;
            Conexao.fecharConexao();
        }catch (SQLException ex) {
            resposta = false;
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }
}

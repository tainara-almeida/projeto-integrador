/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Teste Visual Studio code!
 */
package com.pi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Scarton
 */
public class Conexao {
        
        // CONEXAO COM MYSQL LOCAL
        /*static { // Design Patterns -> Singleton
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        public static Connection getConexao() {
    
            String url = "jdbc:mysql://localhost:3306/senac?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "passw0rd";
    
            Connection con = null;
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
    
        }*/
        
        // CONEXAO COM JAVADB
        static { // Design Patterns -> Singleton
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        public static Connection getConexao() {
    //
            String url = "jdbc:derby://localhost:1527/Andrew";
            String user = "Andrew";
            String password = "Andrew";
    
            Connection con = null;
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
    
        }
    
    }
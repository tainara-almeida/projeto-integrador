/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.uteis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class Formatador {
    public String formataCPF(String cpf){
        return cpf
                .replaceAll(".", "")
                .replaceAll("-", "");
    }
    
    public String formataTelefone(String telefone){
        return telefone
                .replaceAll("(", "")
                .replaceAll(")", "")
                .replaceAll("-", "");
    }
    
    public static String formataDataParaSql(String data){
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada;
        dataFormatada = formato.format(data);
        return dataFormatada;
    }
    
}

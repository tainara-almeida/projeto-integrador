/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.uteis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class Formatador2 {
    public Date formataStringParaData(String data){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date dataFormatada = null;
        try {
            dataFormatada = formato.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Formatador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataFormatada;
    }
}

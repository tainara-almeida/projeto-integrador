/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.enuns;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author andrew.dornelas
 */
@Getter
public enum StatusVenda {
    
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGO("Pago"),
    ENVIADO("Enviando"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");
    
    private String descricao;
    
    StatusVenda(String descricao) {
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}

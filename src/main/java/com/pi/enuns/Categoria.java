/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.enuns;

/**
 *
 * @author andrew.dornelas
 */
public enum Categoria {
    BONECAS_BONECOS("Bonecas e Bonecos"),
    CARRINHOS_CIA("Carrinhos e Cia"),
    INSTRUMENTOS_MUSICAIS("Instrumentos Musicais"),
    LANCADORES("Lancadores"),
    QUEBRA_CABECAS("Quebra-Cabecas"),
    BRINQUEDOS_PARA_PETS("Brinquedos para Pets"),
    ARTES("Artes"),
    COLECIONAVEIS("Colecionaveis"),
    BLOCOS_MONTAR("Blocos de Montar"),
    PELUCIAS("Pelucias"),
    FAZ_DE_CONTA("Faz de conta"),
    PISTAS_AUTORAMAS("Pistas e Autoramas"),
    MINI_VEICULOS_ELETRICOS("Mini veiculos eletricos"),
    JOGOS_TABULEIRO("Jogos de Tabuleiro");
    
    private String descricao;
    
    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

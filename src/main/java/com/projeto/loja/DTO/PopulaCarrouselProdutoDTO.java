package com.projeto.loja.DTO;

import lombok.Data;

@Data
public class PopulaCarrouselProdutoDTO {

    private String nome;
    private double preco;
    private int estoque;
    private String categoria;
    private String marca;
    private String imagemUrl;

    public PopulaCarrouselProdutoDTO(String nome, double preco, int estoque, String categoria, String marca, String imagemUrl) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
        this.marca = marca;
        this.imagemUrl = imagemUrl;
    }
}




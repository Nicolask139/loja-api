package com.projeto.loja.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_produto")
    private long idProduto;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (name = "descricao", nullable = false)
    private String descricao;

    @Column (name = "preco", nullable = false)
    private double preco;

    @Column (name = "estoque", nullable = false)
    private int estoque;

    @Column (name = "data_criacao", nullable = false)
    private LocalDate data_criacao;

    @Column (name = "data_atualizacao", nullable = false)
    private LocalDate data_atualizacao;

    @Column (name = "categoria", nullable = false)
    private String categoria;

    @Column (name = "marca", nullable = false)
    private String marca;

    @Column (name ="imagem_url", nullable = false)
    private String imagemUrl;


}

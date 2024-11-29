package com.projeto.loja.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cartao")
public class CartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @Column(nullable = false, length = 50)
    private String titular; // Nome do titular do cartão

    @Column(nullable = false, length = 16)
    private String numero;

    @Column(nullable = false, length = 5)
    private String validade; // Exemplo: "12/25"

    @Column(nullable = false, length = 3)
    private String cvv;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Bandeira bandeira; // Exemplo: VISA, MASTERCARD, etc.

    public enum Bandeira {
        VISA,
        MASTERCARD,
        AMERICAN_EXPRESS,
        ELO,
        HIPERCARD,
        OUTROS
    }
}

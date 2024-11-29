package com.projeto.loja.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private EnderecoModel endereco;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItensPedidoModel> itensPedido;

    @Column(nullable = false)
    private Double total; // Soma de todos os subtotais dos itens

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status; // Ex: "PENDENTE", "PAGO", "CANCELADO"

    public enum StatusPedido {
        PENDENTE,
        PAGO,
        CANCELADO
    }
}

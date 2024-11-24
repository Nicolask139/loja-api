package com.projeto.loja.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private long idUsuario;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (name = "apelido", nullable = false)
    private String apelido;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "senha", nullable = false)
    private String senha;

    @Column (name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column (name = "telefone")
    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    @Column (name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column (name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column (name = "status")
    private String status;

    @Column (name = "tipoUsuario")
    private String tipoUsuario;

    @Transient
    private String token;

    public UsuarioModel (){

    }

    public UsuarioModel (String nome, String apelido, String email, String senha, String cpf, String telefone, LocalDate dataNascimento, LocalDate dataCadastro, String status, String tipoUsuario) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioModel (String email, String senha, String token){
        this.email = email;
        this.senha = senha;
        this.token = token;
    }

    public UsuarioModel (String email, String senha){
        this.email = email;
        this.senha = senha;

    }

}


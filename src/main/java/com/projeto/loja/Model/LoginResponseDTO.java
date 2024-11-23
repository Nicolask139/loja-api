package com.projeto.loja.Model;

public class LoginResponseDTO {

    private String email;
    private String senha;
    private String token;


    // Construtor
    public LoginResponseDTO(String senha, String email, String token) {
        this.senha = senha;
        this.email = email;
        this.token = token;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

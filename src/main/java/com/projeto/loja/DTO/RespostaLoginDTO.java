package com.projeto.loja.DTO;

import lombok.Data;

@Data
public class RespostaLoginDTO {

    private String email;
    private String senha;
    private String token;

    public RespostaLoginDTO(String senha, String email, String token) {
        this.senha = senha;
        this.email = email;
        this.token = token;
    }
}

package com.projeto.loja.Controller;

import com.projeto.loja.Util.LojaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LojaException.erroExisteEmail.class)
    public ResponseEntity<?> erroExisteEmail (LojaException.erroExisteEmail ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "EMAIL_DUPLICADO", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(LojaException.erroExisteCpf.class)
    public ResponseEntity<?> erroExisteCpf (LojaException.erroExisteCpf ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "CPF_DUPLICADO", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(LojaException.erroExisteApelido.class)
    public ResponseEntity<?> erroExisteApelido (LojaException.erroExisteApelido ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "APELIDO_DUPLICADO", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(LojaException.erroBuscaEmail.class)
    public ResponseEntity<?> erroBuscaEmail (LojaException.erroBuscaEmail ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "E-mail não encontrado", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(LojaException.erroSenhaIncorreta.class)
    public ResponseEntity<?> erroSenhaIncorreta (LojaException.erroSenhaIncorreta ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "Senha incorreta", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(LojaException.erroValidacao.class)
    public ResponseEntity<?> erroValidacao (LojaException.erroValidacao ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "Faltando campos", "message", ex.getMessage()
        ));
    }



}

package com.projeto.loja.Controller;

import com.projeto.loja.Util.LojaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LojaException.ExisteEmail.class)
    public ResponseEntity<?> erroExisteEmail (LojaException.ExisteEmail ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "EMAIL_DUPLICADO", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(LojaException.ExisteApelido.class)
    public ResponseEntity<?> erroExisteApelido (LojaException.ExisteApelido ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "APELIDO_DUPLICADO", "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> erroGenerico (Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "ERRO_INTERNO", "message", "Um erro inesperado ocorreu. Por favor, tente novamente."
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> erroSenhaNula (Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "EMAIL_DUPLICADO", "message", "Um erro inesperado ocorreu. Por favor, tente novamente."
        ));
    }

}

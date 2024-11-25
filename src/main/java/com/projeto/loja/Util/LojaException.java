package com.projeto.loja.Util;

public class LojaException {

    public static class ExisteEmail extends RuntimeException{
        public ExisteEmail(){
            super("E-mail já cadastrado");
        }
    }

    public static class ExisteApelido extends RuntimeException {
        public ExisteApelido() {
            super("Apelido já cadastrado");
        }
    }


}

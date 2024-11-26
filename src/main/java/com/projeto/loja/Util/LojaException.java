package com.projeto.loja.Util;

public class LojaException {

    public static class erroExisteEmail extends RuntimeException{
        public erroExisteEmail(){
            super("E-mail já cadastrado");
        }
    }

    public static class erroExisteApelido extends RuntimeException {
        public erroExisteApelido() {
            super("Apelido já cadastrado");
        }
    }

    public static class erroExisteCpf extends RuntimeException {
        public erroExisteCpf() {
            super("Cpf já cadastrado");
        }
    }

    public static class erroBuscaEmail extends RuntimeException{
        public erroBuscaEmail(){
            super("E-mail não encontrado");
        }
    }

    public static class erroSenhaIncorreta extends RuntimeException{
        public erroSenhaIncorreta(){
            super("A senha esta incorreta");
        }
    }

    public static class erroValidacao extends RuntimeException{
        public erroValidacao(){
            super("Faltando Campos ");
        }
    }


}

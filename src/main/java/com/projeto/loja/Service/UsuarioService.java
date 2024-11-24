package com.projeto.loja.Service;


import com.projeto.loja.Model.UsuarioModel;
import com.projeto.loja.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        if (usuarioRepository.existsByApelido(usuario.getApelido())) {
            throw new IllegalArgumentException("Apelido já cadastrado");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia");
        }

        usuario.setSenha(senhaCriptografada(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    private String senhaCriptografada (String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia");
        }

        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(senha, salt);
    }

    public UsuarioModel loginUsuario(String email, String senha) {
        UsuarioModel usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("E-mail não encontrado"));

        if (!BCrypt.checkpw(senha, usuario.getSenha())) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        return usuario;
    }
}
package com.projeto.loja.Service;


import com.projeto.loja.Model.UsuarioModel;
import com.projeto.loja.Repository.UsuarioRepository;
import com.projeto.loja.Util.LojaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new LojaException.ExisteEmail();
        }

        if (usuarioRepository.existsByApelido(usuario.getApelido())) {
            throw new LojaException.ExisteApelido();
        }

        usuario.setSenha(senhaCriptografada(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    private String senhaCriptografada (String senha) {

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
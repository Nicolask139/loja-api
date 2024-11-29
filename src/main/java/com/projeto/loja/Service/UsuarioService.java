package com.projeto.loja.Service;
import com.projeto.loja.Model.UsuarioModel;
import com.projeto.loja.Repository.UsuarioRepository;
import com.projeto.loja.Util.LojaException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.time.LocalDate;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {

        usuario.setTipoUsuario("comum");
        usuario.setStatus("ativo");
        usuario.setDataCadastro(LocalDate.now());


        validarCamposNaoVazios(usuario);

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new LojaException.erroExisteEmail();
        }

        if (usuarioRepository.existsByApelido(usuario.getApelido())) {
            throw new LojaException.erroExisteApelido();
        }

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new LojaException.erroExisteCpf();
        }

        usuario.setSenha(senhaCriptografada(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    private String senhaCriptografada(String senha) {

        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(senha, salt);
    }

    public UsuarioModel loginUsuario(String email, String senha) {
        UsuarioModel u = usuarioRepository.findByEmail(email).orElseThrow(LojaException.erroBuscaEmail::new);

        if (!BCrypt.checkpw(senha, u.getSenha())) {
            throw new LojaException.erroSenhaIncorreta();
        }

        return u;
    }

    @SneakyThrows
    public UsuarioModel validarCamposNaoVazios(UsuarioModel usuario) {
        for (Field field : usuario.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(usuario);
            System.out.println(value);

            if (value == null || value == "") {
                throw new LojaException.erroValidacao();
            }
        }
        return usuario;
    }

}





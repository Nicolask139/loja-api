package com.projeto.loja.Controller;
import com.projeto.loja.DTO.RespostaLoginDTO;
import com.projeto.loja.Model.UsuarioModel;
import com.projeto.loja.Service.UsuarioService;
import com.projeto.loja.Repository.UsuarioRepository;
import com.projeto.loja.Util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody UsuarioModel usuario) {
            UsuarioModel novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.ok("Usuario Cadastrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody RespostaLoginDTO login) {
        UsuarioModel usuario = usuarioService.loginUsuario(login.getEmail(), login.getSenha());
        String token = JwtUtil.generateJwtToken(usuario);
        RespostaLoginDTO response = new RespostaLoginDTO(usuario.getNome(), usuario.getEmail(), token);
        return ResponseEntity.ok(response);
        }
    }


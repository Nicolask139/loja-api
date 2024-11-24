package com.projeto.loja.Controller;


import com.projeto.loja.Model.LoginResponseDTO;
import com.projeto.loja.Model.UsuarioModel;
import com.projeto.loja.Service.UsuarioService;
import com.projeto.loja.Repository.UsuarioRepository;
import com.projeto.loja.Util.JwtUtil;
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
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioModel usuario) {
        try {
            UsuarioModel novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginResponseDTO login) {
        try {
            boolean usuarioExiste = usuarioRepository.existsByEmail(login.getEmail());
            if (!usuarioExiste) {
                return ResponseEntity.status(401).body("Usuário não encontrado.");
            }
            UsuarioModel usuario = usuarioService.loginUsuario(login.getEmail(), login.getSenha());
            if (!JwtUtil.matchesPassword(login.getSenha(), usuario.getSenha())) {
                return ResponseEntity.status(401).body("Senha inválida.");
            }
            String token = JwtUtil.generateJwtToken(usuario);
            LoginResponseDTO response = new LoginResponseDTO(usuario.getNome(), usuario.getEmail(), token);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

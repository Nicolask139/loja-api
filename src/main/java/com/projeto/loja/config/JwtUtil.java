package com.projeto.loja.config;

import com.projeto.loja.Model.UsuarioModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    //criar uma nova e armazenar essa senha em uma variavel de ambiente do SO
    private static final String SECRET_KEY = "ua_chave_de_256_bits_segura_aqui";
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String generateJwtToken(UsuarioModel usuario) {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS512.getJcaName());

        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(key)
                .compact();
    }

    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static String generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
}

package com.projeto.loja.Repository;


import com.projeto.loja.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel, Long> {

    Optional<UsuarioModel> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByApelido(String apelido);
    boolean existsByCpf(String cpf);


}
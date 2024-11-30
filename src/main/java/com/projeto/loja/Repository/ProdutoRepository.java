package com.projeto.loja.Repository;

import com.projeto.loja.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Optional<ProdutoModel> findByCategoria(String categoria);
}

package com.projeto.loja.Service;

import com.projeto.loja.DTO.PopulaCarrouselProdutoDTO;
import com.projeto.loja.Model.ProdutoModel;
import com.projeto.loja.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    private ProdutoModel produto;

    public List<PopulaCarrouselProdutoDTO> getAllProdutos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> new PopulaCarrouselProdutoDTO(
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getEstoque(),
                        produto.getCategoria(),
                        produto.getMarca(),
                        produto.getImagemUrl()))
                .collect(Collectors.toList());
    }
}

package com.projeto.loja.Controller;

import com.projeto.loja.DTO.PopulaCarrouselProdutoDTO;
import com.projeto.loja.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/carrosel")
    public List<PopulaCarrouselProdutoDTO> getTodosProdutos() {
        return produtoService.getAllProdutos();
    }
}

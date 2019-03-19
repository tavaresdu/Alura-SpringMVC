package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.dao.ProdutoDAO;
import br.edu.tavaresdu.springmvc.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/produto/form")
    public String form() {
        return "produto/form";
    }

    @RequestMapping("/produto")
    public String grava(Produto produto) {
        System.out.println(produto);
        produtoDAO.save(produto);
        return "produto/ok";
    }
}

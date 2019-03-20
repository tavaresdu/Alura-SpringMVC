package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.dao.ProdutoDAO;
import br.edu.tavaresdu.springmvc.loja.model.Produto;
import br.edu.tavaresdu.springmvc.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produto/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String grava(Produto produto) {
        System.out.println(produto);
        produtoDAO.save(produto);
        return "produto/ok";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView lista() {
        ModelAndView modelAndView = new ModelAndView("produto/lista");
        modelAndView.addObject("produtos", produtoDAO.listAll());
        return modelAndView;
    }
}

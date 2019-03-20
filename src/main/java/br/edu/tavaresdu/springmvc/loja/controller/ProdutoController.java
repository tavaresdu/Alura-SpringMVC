package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.dao.ProdutoDAO;
import br.edu.tavaresdu.springmvc.loja.model.Produto;
import br.edu.tavaresdu.springmvc.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
        System.out.println(produto);
        produtoDAO.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto Cadastrado com Sucesso!");
        return new ModelAndView("redirect:produto");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("produto/lista");
        modelAndView.addObject("produtos", produtoDAO.listAll());
        return modelAndView;
    }
}

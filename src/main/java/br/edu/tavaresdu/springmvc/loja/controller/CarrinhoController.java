package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.dao.ProdutoDAO;
import br.edu.tavaresdu.springmvc.loja.model.CarrinhoCompras;
import br.edu.tavaresdu.springmvc.loja.model.CarrinhoItem;
import br.edu.tavaresdu.springmvc.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        carrinhoCompras.addCarrinhoItem(new CarrinhoItem(produtoDAO.find(produtoId), tipoPreco));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView itens() {
        return new ModelAndView("carrinho/itens");
    }
}

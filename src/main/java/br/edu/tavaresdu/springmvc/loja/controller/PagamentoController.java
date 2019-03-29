package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.model.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public ModelAndView finalizar(RedirectAttributes attributes) {
        System.out.println(carrinhoCompras.getTotal());
        attributes.addFlashAttribute("sucesso", "Pagamento realizado com sucesso!");
        return new ModelAndView("redirect:/produtos");
    }
}

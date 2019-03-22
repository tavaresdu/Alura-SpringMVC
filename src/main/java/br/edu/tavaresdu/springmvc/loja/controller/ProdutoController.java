package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.dao.ProdutoDAO;
import br.edu.tavaresdu.springmvc.loja.model.Produto;
import br.edu.tavaresdu.springmvc.loja.model.TipoPreco;
import br.edu.tavaresdu.springmvc.loja.infra.FileSaver;
import br.edu.tavaresdu.springmvc.loja.validator.ProdutoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidator());
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produto/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result,
                               RedirectAttributes redirectAttributes) throws IOException {
        if (result.hasErrors())
            return form(produto);
        produto.setSumarioPath(fileSaver.write("arquivos-sumario", sumario));
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

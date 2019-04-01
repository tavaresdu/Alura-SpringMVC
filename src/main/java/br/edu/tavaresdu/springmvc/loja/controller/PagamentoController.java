package br.edu.tavaresdu.springmvc.loja.controller;

import br.edu.tavaresdu.springmvc.loja.model.CarrinhoCompras;
import br.edu.tavaresdu.springmvc.loja.model.DadosPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes attributes) {
        return () -> {
            String uri = "http://book-payment.herokuapp.com/payment";
            try {
                String response = restTemplate.postForObject(uri,
                        new DadosPagamento(carrinhoCompras.getTotal()), String.class);
                attributes.addFlashAttribute("mensagem", response);
                carrinhoCompras.limpaCarrinho();
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                attributes.addFlashAttribute("mensagem", "Valor maior que o permitido!");
            }
            return new ModelAndView("redirect:/produto");
        };
    }
}

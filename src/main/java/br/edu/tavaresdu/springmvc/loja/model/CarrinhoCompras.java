package br.edu.tavaresdu.springmvc.loja.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itens;

    public CarrinhoCompras() {
        this.itens = new LinkedHashMap<>();
    }

    public void addCarrinhoItem(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }

    private int getQuantidade(CarrinhoItem item) {
        if (itens.containsKey(item)) {
            return itens.get(item);
        }
        return 0;
    }

    public int getQuantidade() {
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }
}
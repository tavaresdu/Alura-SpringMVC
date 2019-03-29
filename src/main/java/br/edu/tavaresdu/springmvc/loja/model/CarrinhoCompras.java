package br.edu.tavaresdu.springmvc.loja.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<CarrinhoItem, Integer> itens;

    public CarrinhoCompras() {
        this.itens = new LinkedHashMap<>();
    }

    public void addCarrinhoItem(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }

    public int getQuantidade(CarrinhoItem item) {
        if (itens.containsKey(item)) {
            return itens.get(item);
        }
        return 0;
    }

    public int getQuantidade() {
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }

    public Set<CarrinhoItem> getItens() {
        return itens.keySet();
    }

    public BigDecimal getTotal(CarrinhoItem item) {
        return item.getTotal(getQuantidade(item));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CarrinhoItem item : itens.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }
}

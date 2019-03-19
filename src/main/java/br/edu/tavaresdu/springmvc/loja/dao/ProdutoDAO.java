package br.edu.tavaresdu.springmvc.loja.dao;

import br.edu.tavaresdu.springmvc.loja.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Produto produto) {
        entityManager.persist(produto);
    }
}

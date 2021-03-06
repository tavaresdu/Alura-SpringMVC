package br.edu.tavaresdu.springmvc.loja.dao;

import br.edu.tavaresdu.springmvc.loja.model.Produto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @CacheEvict(value = "produtosHome", allEntries = true)
    public void save(Produto produto) {
        entityManager.persist(produto);
    }

    public List<Produto> listAll() {
        return entityManager.createQuery("SELECT p from Produto p", Produto.class).getResultList();
    }

    public Produto find(int id) {
        return entityManager.createQuery("SELECT distinct(p) FROM Produto p JOIN FETCH p.precos precos " +
                "where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
    }
}

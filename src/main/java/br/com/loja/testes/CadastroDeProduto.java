package br.com.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNome("XPTO");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNome("asdasdas");
		em.flush();
		em.clear();
		em.remove(celulares);
		em.flush();
		
		
	}
}








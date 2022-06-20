package br.com.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.loja.modelo.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("IPhone X");
		celular.setDescricao("Muito Legal");
		celular.setPreco(new BigDecimal("10000"));
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
		
	}
}








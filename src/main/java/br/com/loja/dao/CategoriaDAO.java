package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar (Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar (Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.merge(categoria);
	}
	
	public void remover (Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
}

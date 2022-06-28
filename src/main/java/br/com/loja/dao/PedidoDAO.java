package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;

public class PedidoDAO {

	private EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar (Pedido pedido) {
		this.em.persist(pedido);
	}

}

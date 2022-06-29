package br.com.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.PedidoDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import br.com.loja.vo.RelatorioDeVendasVo;

public class PerformanceConsultas {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(1l);
		
		em.close();
		System.out.println(pedido.getCliente().getNome());
		
		
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("IPhone X", "Muito Legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("800"), videogames);
		Produto macbook = new Produto("Macbook", "Macbook pro ", new BigDecimal("800"), informatica);
		
		
		Cliente cliente = new Cliente("Rodrigo", "1234567");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(40, pedido, videogame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(2, pedido, macbook));
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		PedidoDAO pedidoDao = new PedidoDAO(em);
		
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		
		em.close();
		
		
	}
}

package br.com.fucapi.projetoSistemas.delivery.dao.teste;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Test;

import br.com.fucapi.projetoSistemas.delivery.bean.Produto;
import br.com.fucapi.projetoSistemas.delivery.bean.TipoProdutoEnum;
import br.com.fucapi.projetoSistemas.delivery.dao.JPAUtil;
import br.com.fucapi.projetoSistemas.delivery.dao.ProdutoDAO;

public class ProdutoDAOTest {

	@Test
	public void testProdutoDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCadastrar() {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		Produto produto = new Produto();
		produto.setNome("HOT SPICE");
		produto.setPreco("2,40");
		produto.setTipoProduto(TipoProdutoEnum.TIPO_SUSHI_HOT);
		
		produtoDAO.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
		
		Assert.assertNotNull(produto.getId());
		
		
	}

	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

}

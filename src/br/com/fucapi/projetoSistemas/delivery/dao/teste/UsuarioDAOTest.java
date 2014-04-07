package br.com.fucapi.projetoSistemas.delivery.dao.teste;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Test;

import br.com.fucapi.projetoSistemas.delivery.bean.Usuario;
import br.com.fucapi.projetoSistemas.delivery.dao.JPAUtil;
import br.com.fucapi.projetoSistemas.delivery.dao.UsuarioDAO;

public class UsuarioDAOTest {

	@Test
	public void testUsuarioDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCadastrar() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		entityManager.getTransaction().begin();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Bruno");
		usuario.setEmail("bruno.abia@gmail.com");
		usuario.setTelefone("8159-1643");
		usuario.setEndereco("RUA 100 NUCLEO 12 NUMERO 9");
		
		dao.cadastrar(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		Assert.assertNotNull(usuario.getId());
	}

	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

		
	
}

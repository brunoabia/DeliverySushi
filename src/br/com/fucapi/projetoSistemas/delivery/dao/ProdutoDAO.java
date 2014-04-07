package br.com.fucapi.projetoSistemas.delivery.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fucapi.projetoSistemas.delivery.bean.Produto;


public class ProdutoDAO {
	
	private EntityManager entityManager;
	
	public ProdutoDAO(EntityManager entityManager){
		this.entityManager= entityManager;
	}
	public void cadastrar(Produto produto){
		entityManager.persist(produto);
	}
	
	public void alterar(Produto produto){
		entityManager.merge(produto);
	}
	
	public void excluir(Produto produto){
		entityManager.remove(entityManager.merge(produto));
	}
	
	public void consultar(Long id){
		entityManager.getReference(Produto.class, id);
	}

	public List<Produto> listar(){
		
		String sql = "Select prod from Produto prod order by nome";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	

}

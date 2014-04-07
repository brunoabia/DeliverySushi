package br.com.fucapi.projetoSistemas.delivery.control.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fucapi.projetoSistemas.delivery.bean.Produto;
import br.com.fucapi.projetoSistemas.delivery.dao.JPAUtil;
import br.com.fucapi.projetoSistemas.delivery.dao.ProdutoDAO;

@ViewScoped
@ManagedBean
public class ProdutoMB {

	
	private Produto produto = new Produto();
	public List<Produto> listProduto = new ArrayList<Produto>();
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getListProduto() {
		return listProduto;
	}
	
	public void salvar(){
		//Chama a conexao com SGBD
		System.out.println(produto.getTipoProduto().getName());
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO  ProdutoDAO = new ProdutoDAO(em);
		
		//abrindo transicao do banco de dados
		em.getTransaction().begin();
		if(produto.getId()!=null){
			ProdutoDAO.alterar(produto);
		}else{
			
			ProdutoDAO.cadastrar(produto);	
		}
		em.getTransaction().commit();
		em.close();
		produto= new Produto();
		carregarProdutos();
	
	}
	
	@PostConstruct
	public void carregarProdutos(){
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		listProduto = produtoDAO.listar();
		em.close();
	}
	
	public void exlcuir(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		entityManager.getTransaction().begin();
		produtoDAO.excluir(produto);
		entityManager.getTransaction().commit();
		entityManager.close();
		carregarProdutos();
	}
	
	
	public void redirectMenu(){  
	       
	       try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     
	  } 
	
	
	
	
}

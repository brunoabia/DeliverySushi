package br.com.fucapi.projetoSistemas.delivery.control.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fucapi.projetoSistemas.delivery.bean.Usuario;
import br.com.fucapi.projetoSistemas.delivery.dao.JPAUtil;
import br.com.fucapi.projetoSistemas.delivery.dao.UsuarioDAO;

@ViewScoped
@ManagedBean
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	public List<Usuario> listUsuarios = new ArrayList<Usuario>();
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario=usuario;
	}
	
	public List<Usuario> getListUsuarios(){
		return listUsuarios;
	}
	
	
	public void salvar(){
		//Chama a conexao com SGBD
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO  usuarioDAO = new UsuarioDAO(em);
		
		//abrindo transicao do banco de dados
		em.getTransaction().begin();
		if(usuario.getId()!=null){
			usuarioDAO.alterar(usuario);
		}else{
			usuarioDAO.cadastrar(usuario);	
		}
		em.getTransaction().commit();
		em.close();
		usuario= new Usuario();
		carregarUsuarios();
	
	}
	
	@PostConstruct
	public void carregarUsuarios(){
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		listUsuarios = usuarioDAO.listar();
		em.close();
	}
	
	public void exlcuir(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
		entityManager.getTransaction().begin();
		usuarioDAO.excluir(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		carregarUsuarios();
	}
	
	
	public void redirectUsuario(){  
	       try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     
	  }
	
	public void redirectProduto(){  
	       try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("produto.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     
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

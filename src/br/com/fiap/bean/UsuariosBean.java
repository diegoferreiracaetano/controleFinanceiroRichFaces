package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.UsuariosDao;
import br.com.fiap.entity.Usuarios;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="usuarios")
@RequestScoped
public class UsuariosBean {

	private Usuarios usuarios = new Usuarios();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	public String add(){
		try{
		UsuariosDao dao = RepositoryDao.getUsuariosDao();
		setMensagem(dao.insert(usuarios));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		UsuariosDao dao = RepositoryDao.getUsuariosDao();
		setMensagem(dao.update(usuarios));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		UsuariosDao dao = RepositoryDao.getUsuariosDao();
		setMensagem(dao.delete(usuarios.getId()));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String view(){
		try{		
			return  "edit.faces";
		}catch(Exception e){
			return "/erro";
		}
				
	}
	public List<Usuarios> getLista(){
		return  RepositoryDao.getUsuariosDao().findAll();
	}
}

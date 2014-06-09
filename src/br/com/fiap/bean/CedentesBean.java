package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.CedentesDao;
import br.com.fiap.entity.Cedentes;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="cedentes")
@RequestScoped
public class CedentesBean {

	@ManagedProperty(value="#{param.id}")
	private int id;
	private Cedentes cedentes = new Cedentes();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Cedentes getCedentes() {
		return cedentes;
	}

	public void setCedentes(Cedentes cedentes) {
		this.cedentes = cedentes;
	}
	
	public String add(){
		try{
		CedentesDao dao = RepositoryDao.getCedentesDao();
		setMensagem(dao.insert(cedentes));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		CedentesDao dao = RepositoryDao.getCedentesDao();
		setMensagem(dao.update(cedentes));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		CedentesDao dao = RepositoryDao.getCedentesDao();
		setMensagem(dao.delete(cedentes.getId()));
			return "/add";
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
	public List<Cedentes> getLista(){
		return  RepositoryDao.getCedentesDao().findAll();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

}

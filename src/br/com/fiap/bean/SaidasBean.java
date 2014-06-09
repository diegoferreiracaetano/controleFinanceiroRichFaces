package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.SaidasDao;
import br.com.fiap.entity.Saidas;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="saidas")
@RequestScoped
public class SaidasBean {

	private Saidas saidas = new Saidas();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Saidas getSaidas() {
		return saidas;
	}

	public void setSaidas(Saidas saidas) {
		this.saidas = saidas;
	}
	
	public String add(){
		try{
		SaidasDao dao = RepositoryDao.getSaidasDao();
		setMensagem(dao.insert(saidas));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		SaidasDao dao = RepositoryDao.getSaidasDao();
		setMensagem(dao.update(saidas));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		SaidasDao dao = RepositoryDao.getSaidasDao();
		setMensagem(dao.delete(saidas.getId()));
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
	public List<Saidas> getLista(){
		return  RepositoryDao.getSaidasDao().findAll();
	}
}

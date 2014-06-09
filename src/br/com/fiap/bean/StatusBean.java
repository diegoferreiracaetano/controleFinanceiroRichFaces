package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.StatusDao;
import br.com.fiap.entity.Status;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="status")
@RequestScoped
public class StatusBean {

	private Status status = new Status();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String add(){
		try{
		StatusDao dao = RepositoryDao.getStatusDao();
		setMensagem(dao.insert(status));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		StatusDao dao = RepositoryDao.getStatusDao();
		setMensagem(dao.update(status));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		StatusDao dao = RepositoryDao.getStatusDao();
		setMensagem(dao.delete(status.getId()));
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
	public List<Status> getLista(){
		return  RepositoryDao.getStatusDao().findAll();
	}
}

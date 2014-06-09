package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.ContasDao;
import br.com.fiap.entity.Contas;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="contas")
@RequestScoped
public class ContasBean {

	private Contas contas = new Contas();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Contas getContas() {
		return contas;
	}

	public void setContas(Contas contas) {
		this.contas = contas;
	}
	
	public String add(){
		try{
		ContasDao dao = RepositoryDao.getContasDao();
		setMensagem(dao.insert(contas));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		ContasDao dao = RepositoryDao.getContasDao();
		setMensagem(dao.update(contas));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		ContasDao dao = RepositoryDao.getContasDao();
		setMensagem(dao.delete(contas.getId()));
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
	public List<Contas> getLista(){
		return  RepositoryDao.getContasDao().findAll();
	}
}

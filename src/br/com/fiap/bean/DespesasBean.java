package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.DespesasDao;
import br.com.fiap.entity.Despesas;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="despesas")
@RequestScoped
public class DespesasBean {

	private Despesas despesas = new Despesas();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}
	
	public String add(){
		try{
		DespesasDao dao = RepositoryDao.getDespesasDao();
		setMensagem(dao.insert(despesas));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		DespesasDao dao = RepositoryDao.getDespesasDao();
		setMensagem(dao.update(despesas));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		DespesasDao dao = RepositoryDao.getDespesasDao();
		setMensagem(dao.delete(despesas.getId()));
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
	public List<Despesas> getLista(){
		return  RepositoryDao.getDespesasDao().findAll();
	}
}

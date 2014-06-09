package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.PagamentosDao;
import br.com.fiap.entity.Pagamentos;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="pagamentos")
@RequestScoped
public class PagamentosBean {

	private Pagamentos pagamentos = new Pagamentos();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Pagamentos getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Pagamentos pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public String add(){
		try{
		PagamentosDao dao = RepositoryDao.getPagamentosDao();
		setMensagem(dao.insert(pagamentos));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		PagamentosDao dao = RepositoryDao.getPagamentosDao();
		setMensagem(dao.update(pagamentos));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		PagamentosDao dao = RepositoryDao.getPagamentosDao();
		setMensagem(dao.delete(pagamentos.getId()));
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
	public List<Pagamentos> getLista(){
		return  RepositoryDao.getPagamentosDao().findAll();
	}
}

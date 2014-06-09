package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.FormaPagamentosDao;
import br.com.fiap.entity.FormaPagamentos;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="formaPagamentos")
@RequestScoped
public class FormaPagamentosBean {

	private FormaPagamentos formaPagamentos = new FormaPagamentos();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public FormaPagamentos getFormaPagamentos() {
		return formaPagamentos;
	}

	public void setFormaPagamentos(FormaPagamentos formaPagamentos) {
		this.formaPagamentos = formaPagamentos;
	}
	
	public String add(){
		try{
		FormaPagamentosDao dao = RepositoryDao.getFormaPagamentosDao();
		setMensagem(dao.insert(formaPagamentos));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		FormaPagamentosDao dao = RepositoryDao.getFormaPagamentosDao();
		setMensagem(dao.update(formaPagamentos));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		FormaPagamentosDao dao = RepositoryDao.getFormaPagamentosDao();
		setMensagem(dao.delete(formaPagamentos.getId()));
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
	public List<FormaPagamentos> getLista(){
		return  RepositoryDao.getFormaPagamentosDao().findAll();
	}
}

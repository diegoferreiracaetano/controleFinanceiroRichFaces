package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.CedentesDao;
import br.com.fiap.dao.DespesasDao;
import br.com.fiap.dao.FormaPagamentosDao;
import br.com.fiap.dao.SaidasDao;
import br.com.fiap.entity.Cedentes;
import br.com.fiap.entity.Despesas;
import br.com.fiap.entity.FormaPagamentos;
import br.com.fiap.entity.Saidas;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="saidas")
@RequestScoped
public class SaidasBean {

	private Saidas saidas = new Saidas();
	private String mensagem;
	private int despesasId,formaPagamentosId,contasId;
	
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
	
	public List<SelectItem> getDespesas() {
		DespesasDao despesasDao = RepositoryDao.getDespesasDao();
		List<Despesas> despesas = despesasDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null,""));
		for (Despesas lista : despesas) {
			itens.add(new SelectItem(lista, lista.getDescricao()));
		}
		return itens;
	}
	
	public List<SelectItem> getFormaPagamentos() {
		FormaPagamentosDao formaPagamentosDao = RepositoryDao.getFormaPagamentosDao();
		List<FormaPagamentos> formaPagamentos = formaPagamentosDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null,""));
		for (FormaPagamentos lista : formaPagamentos) {
			itens.add(new SelectItem(lista, lista.getDescricao()));
		}
		return itens;
	}
	
	public List<SelectItem> getCedentes() {
		CedentesDao cedentesDao = RepositoryDao.getCedentesDao();
		List<Cedentes> cedentes = cedentesDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null,""));
		for (Cedentes lista : cedentes) {
			itens.add(new SelectItem(lista, lista.getNome()));
		}
		return itens;
	}

	public int getDespesasId() {
		return despesasId;
	}

	public void setDespesasId(int despesasId) {
		this.despesasId = despesasId;
	}

	public int getContasId() {
		return contasId;
	}

	public void setContasId(int contasId) {
		this.contasId = contasId;
	}

	public int getFormaPagamentosId() {
		return formaPagamentosId;
	}

	public void setFormaPagamentosId(int formaPagamentosId) {
		this.formaPagamentosId = formaPagamentosId;
	}
}

package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.ClientesDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="clientes")
@RequestScoped
public class ClientesBean {

	private Clientes clientes = new Clientes();
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	
	public String add(){
		try{
		ClientesDao dao = RepositoryDao.getClientesDao();
		setMensagem(dao.insert(clientes));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	
	public String edit(){
		try{
		ClientesDao dao = RepositoryDao.getClientesDao();
		setMensagem(dao.update(clientes));
			return "index";
		}catch (Exception e) {
			return "/erro";
		}
	}
	public String delete(){
		try{
		ClientesDao dao = RepositoryDao.getClientesDao();
		setMensagem(dao.delete(clientes.getId()));
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
	public List<Clientes> getLista(){
		return  RepositoryDao.getClientesDao().findAll();
	}
}

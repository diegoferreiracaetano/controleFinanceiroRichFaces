package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.FranquiasDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Franquias;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name = "franquias")
@RequestScoped
public class FranquiasBean {

	private Franquias franquias = new Franquias();
	private String mensagem;
	private int clienteId;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Franquias getFranquias() {
		return franquias;
	}

	public void setFranquias(Franquias franquias) {
		this.franquias = franquias;
	}

	public String add() {
		try {
			FranquiasDao dao = RepositoryDao.getFranquiasDao();
			setMensagem(dao.insert(franquias));
			return "index";
		} catch (Exception e) {
			return "/erro";
		}
	}

	public String edit() {
		try {
			FranquiasDao dao = RepositoryDao.getFranquiasDao();
			setMensagem(dao.update(franquias));
			return "index";
		} catch (Exception e) {
			return "/erro";
		}
	}

	public String delete() {
		try {
			FranquiasDao dao = RepositoryDao.getFranquiasDao();
			setMensagem(dao.delete(franquias.getId()));
			return "index";
		} catch (Exception e) {
			return "/erro";
		}
	}

	public String view() {
		try {
			return "edit.faces";
		} catch (Exception e) {
			return "/erro";
		}

	}

	public List<Franquias> getLista() {
		return RepositoryDao.getFranquiasDao().findAll();
	}

	public List<SelectItem> getClientes() {
		ClientesDao clientesDao = RepositoryDao.getClientesDao();
		List<Clientes> clientes = clientesDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for (Clientes lista : clientes) {
			itens.add(new SelectItem(lista, lista.getNome()));
		}
		return itens;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public void trechoChanged(ValueChangeEvent e) {
		Integer p = (Integer) e.getNewValue();
		setClienteId(p);
	}
}

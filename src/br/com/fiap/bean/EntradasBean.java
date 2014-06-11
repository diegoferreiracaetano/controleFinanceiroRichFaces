package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.ContasDao;
import br.com.fiap.dao.EntradasDao;
import br.com.fiap.dao.FormaPagamentosDao;
import br.com.fiap.dao.FranquiasDao;
import br.com.fiap.dao.PagamentosDao;
import br.com.fiap.entity.Contas;
import br.com.fiap.entity.Entradas;
import br.com.fiap.entity.FormaPagamentos;
import br.com.fiap.entity.Franquias;
import br.com.fiap.entity.Pagamentos;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name = "entradas")
@RequestScoped
public class EntradasBean {

	private Entradas entradas = new Entradas();
	private String mensagem;
	private int franquiasId, formaPagamentosId, contasId;
	private List<Pagamentos> pagamentosList;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Entradas getEntradas() {
		return entradas;
	}

	public void setEntradas(Entradas entradas) {
		this.entradas = entradas;
	}

	public String add() {
		try {

			this.gerarPagamento();
			System.out.println(entradas.getPagamentosList());
			EntradasDao dao = RepositoryDao.getEntradasDao();
			PagamentosDao pagamentoDao = RepositoryDao.getPagamentosDao();
			setMensagem(dao.insert(entradas));
			
					

			return "index";
		} catch (Exception e) {
			
			System.out.println(e);
			return "/erro";
		}
	}

	public String edit() {
		try {
			EntradasDao dao = RepositoryDao.getEntradasDao();
			setMensagem(dao.update(entradas));
			return "index";
		} catch (Exception e) {
			return "/erro";
		}
	}

	public String delete() {
		try {
			EntradasDao dao = RepositoryDao.getEntradasDao();
			setMensagem(dao.delete(entradas.getId()));
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

	public List<SelectItem> getFranquias() {
		FranquiasDao franquiasDao = RepositoryDao.getFranquiasDao();
		List<Franquias> franquias = franquiasDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for (Franquias lista : franquias) {
			itens.add(new SelectItem(lista, lista.getNome()));
		}
		return itens;
	}

	public List<SelectItem> getFormaPagamentos() {
		FormaPagamentosDao formaPagamentosDao = RepositoryDao
				.getFormaPagamentosDao();
		List<FormaPagamentos> formaPagamentos = formaPagamentosDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null, ""));
		for (FormaPagamentos lista : formaPagamentos) {
			itens.add(new SelectItem(lista, lista.getDescricao()));
		}
		return itens;
	}

	public List<SelectItem> getContas() {
		ContasDao contasDao = RepositoryDao.getContasDao();
		List<Contas> contas = contasDao.findAll();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for (Contas lista : contas) {
			itens.add(new SelectItem(lista, lista.getNome()));
		}
		return itens;
	}

	public List<Entradas> getLista() {
		return RepositoryDao.getEntradasDao().findAll();
	}

	public int getFranquiasId() {
		return franquiasId;
	}

	public void setFranquiasId(int franquiasId) {
		this.franquiasId = franquiasId;
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


	public void gerarPagamento() {
		
		pagamentosList = new ArrayList<Pagamentos>();
		
		pagamentosList.clear();
		if (entradas != null) {
			Date dataAtual = new Date();
			FormaPagamentos formaPagamentos = entradas.getFormaPagamentosId();
			
			String[] parcelas = formaPagamentos.getDescricao().split("/");
			if(parcelas == null){
				parcelas[0] = formaPagamentos.getDescricao();
				
			}		
			for (int i = 0; i < formaPagamentos.getQuantidadeParcelas(); i++) {

				Calendar calendar = new GregorianCalendar();
				calendar.add(Calendar.DATE,
						Integer.parseInt(parcelas[i]));
				Date dataPagamento = calendar.getTime();

				pagamentosList.add(new Pagamentos("Parcela "+ (i+1) + "/"
						+ formaPagamentos.getQuantidadeParcelas(), dataAtual,
						dataPagamento, null, (entradas.getValorTotal() / formaPagamentos
								.getQuantidadeParcelas())));
			}
		}
	}

	public List<Pagamentos> getPagamentosList() {
		return pagamentosList;
	}

	public void setPagamentosList(List<Pagamentos> pagamentosList) {
		this.pagamentosList = pagamentosList;
	}
}

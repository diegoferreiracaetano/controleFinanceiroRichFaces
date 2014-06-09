package br.com.fiap.repository;

import br.com.fiap.dao.CedentesDao;
import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.ContasDao;
import br.com.fiap.dao.DespesasDao;
import br.com.fiap.dao.EntradasDao;
import br.com.fiap.dao.FormaPagamentosDao;
import br.com.fiap.dao.FranquiasDao;
import br.com.fiap.dao.PagamentosDao;
import br.com.fiap.dao.SaidasDao;
import br.com.fiap.dao.StatusDao;
import br.com.fiap.dao.UsuariosDao;

public final class RepositoryDao {

	static CedentesDao cedentesDao;
	static ClientesDao clientesDao;
	static ContasDao contasDao;
	static DespesasDao despesasDao;
	static EntradasDao entradasDao;
	static FormaPagamentosDao formaPagamentosDao;
	static FranquiasDao franquiasDao;
	static PagamentosDao pagamentosDao;
	static SaidasDao saidasDao;
	static StatusDao statusDao;
	static UsuariosDao usuariosDao;
	
	public static CedentesDao getCedentesDao(){
		if(cedentesDao == null){
			cedentesDao = new CedentesDao();
		}
		return cedentesDao;
	}
	
	public static ClientesDao getClientesDao(){
		if(clientesDao == null){
			clientesDao = new ClientesDao();
		}
		return clientesDao;
	}
	
	public static ContasDao getContasDao(){
		if(contasDao == null){
			contasDao = new ContasDao();
		}
		return contasDao;
	}
	
	public static DespesasDao getDespesasDao(){
		if(despesasDao == null){
			despesasDao = new DespesasDao();
		}
		return despesasDao;
	}
	
	public static EntradasDao getEntradasDao(){
		if(entradasDao == null){
			entradasDao = new EntradasDao();
		}
		return entradasDao;
	}
	
	public static FormaPagamentosDao getFormaPagamentosDao(){
		if(formaPagamentosDao == null){
			formaPagamentosDao = new FormaPagamentosDao();
		}
		return formaPagamentosDao;
	}
	
	public static FranquiasDao getFranquiasDao(){
		if(franquiasDao == null){
			franquiasDao = new FranquiasDao();
		}
		return franquiasDao;
	}
	
	public static PagamentosDao getPagamentosDao(){
		if(pagamentosDao == null){
			pagamentosDao = new PagamentosDao();
		}
		return pagamentosDao;
	}
	
	public static SaidasDao getSaidasDao(){
		if(saidasDao == null){
			saidasDao = new SaidasDao();
		}
		return saidasDao;
	}
	
	public static StatusDao getStatusDao(){
		if(statusDao == null){
			statusDao = new StatusDao();
		}
		return statusDao;
	}
	
	public static UsuariosDao getUsuariosDao(){
		if(usuariosDao == null){
			usuariosDao = new UsuariosDao();
		}
		return usuariosDao;
	}
	
}

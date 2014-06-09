package br.com.fiap.dao;
import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Serializable> {
	String insert(T entity);

	String update(T entity);

	String delete(Integer primaryKey) throws Exception;

	List<T> findAll();

	List<T> findEspecific(Integer id);

	T findById(Integer primaryKey);
}
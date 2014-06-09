package br.com.fiap.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GenericDao<T extends Serializable> implements Dao<T>{

	List<T> lista;


	EntityManagerFactory emf = Persistence.createEntityManagerFactory("financeiro");
	EntityManager entityManager = emf.createEntityManager();
	
	public GenericDao() {
		
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		lista = entityManager.createQuery(("FROM " + getGenericClass().getName())).getResultList();
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEspecific(Integer id) {
		Query query = entityManager.createQuery(("FROM " + getGenericClass().getName()+" WHERE id = :paramId "));
		query.setParameter("paramId", id);
		
		lista = query.getResultList();
		
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String delete(Integer primaryKey) {
		entityManager = getEntityManager();
		try{
			T entity = (T) entityManager.find(getGenericClass(), primaryKey);
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return getGenericClass().getSimpleName()+" Deletado. ";
		}catch (Exception ex) {
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Integer primaryKey) {
		
		try {
		      //Consulta um Cliente pelo seu ID.
			entityManager = getEntityManager();	
			entityManager.getTransaction().begin();
			return (T) entityManager.find(getGenericClass(), primaryKey);
	
		}catch (Exception ex) {
			return null;
		}
	}
	
	@Override
    public String update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return getGenericClass().getSimpleName()+" Alterado. ";
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			return ex.getMessage();
		}
    }
	

	public EntityManager getEntityManager() {
		if(entityManager == null || !(entityManager.isOpen())){
			return ((EntityManagerFactory) entityManager).createEntityManager();
		}
		return entityManager;
	}

	 private Class<?> getGenericClass() {
	        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[0];
	        return clazz;
	    }
	 
	@Override
	public String insert(T entity) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return getGenericClass().getSimpleName()+" Salvo. ";
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			return ex.getMessage();
		}
	}
	
}

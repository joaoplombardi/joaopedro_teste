package br.com.teste.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.teste.dao.GenericDao;
import br.com.teste.exceptions.CommitException;
import br.com.teste.exceptions.EntityNotFoundException;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	
	protected EntityManager em;
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void create(E entity) {
		em.getTransaction().begin();
		em.persist(entity);		
	}

	@Override
	public E read(K id) throws EntityNotFoundException {
		E entity = em.find(clazz, id);
		if(entity == null) throw new EntityNotFoundException();
		return entity;
	}

	@Override
	public void update(E entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.flush();
		
	}

	@Override
	public void delete(K id) throws EntityNotFoundException {
		E entity = read(id);
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
		
	}

	@Override
	public List<E> getAll() throws EntityNotFoundException {
		TypedQuery<E> query = em.createQuery("FROM "+ clazz.getName(), clazz); 
		return query.getResultList();
	}

}

package br.com.teste.dao;

import java.util.List;

import br.com.teste.exceptions.CommitException;
import br.com.teste.exceptions.EntityNotFoundException;

public interface GenericDao<E, K> {
	
	void create(E entity);
	E read(K id) throws EntityNotFoundException;
	void update(E entity);
	void delete(K id) throws EntityNotFoundException;
	void commit() throws CommitException;
	List<E> getAll() throws EntityNotFoundException;
	
}

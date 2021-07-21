package br.com.teste.dao.impl;

import javax.persistence.EntityManager;

import br.com.teste.dao.CorridaDao;
import br.com.teste.models.Corrida;

public class CorridaDaoImpl extends GenericDaoImpl<Corrida, Long> implements CorridaDao{
	public CorridaDaoImpl(EntityManager em) {
		super(em);
	}
}

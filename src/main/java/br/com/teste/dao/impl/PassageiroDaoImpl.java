package br.com.teste.dao.impl;

import javax.persistence.EntityManager;

import br.com.teste.dao.PassageiroDao;
import br.com.teste.models.Passageiro;

public class PassageiroDaoImpl extends GenericDaoImpl<Passageiro, Long> implements PassageiroDao{
	public PassageiroDaoImpl(EntityManager em) {
		super(em);
	}
}

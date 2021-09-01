package br.com.teste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.teste.dao.MotoristaDao;
import br.com.teste.exceptions.EntityNotFoundException;
import br.com.teste.models.Motorista;

public class MotoristaDaoImpl extends GenericDaoImpl<Motorista, Long> implements MotoristaDao{
	public MotoristaDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Motorista> getActive() throws EntityNotFoundException{
		TypedQuery<Motorista> query = super.em.createQuery("FROM Motorista m WHERE m.status = 0", Motorista.class);
		return query.getResultList();
	}
}

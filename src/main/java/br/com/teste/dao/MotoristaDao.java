package br.com.teste.dao;

import java.util.List;

import br.com.teste.exceptions.EntityNotFoundException;
import br.com.teste.models.Motorista;

public interface MotoristaDao extends GenericDao<Motorista, Long>{
	List<Motorista> getActive() throws EntityNotFoundException;
}

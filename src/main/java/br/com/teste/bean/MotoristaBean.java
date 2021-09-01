package br.com.teste.bean;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import br.com.teste.dao.impl.MotoristaDaoImpl;
import br.com.teste.exceptions.CommitException;
import br.com.teste.exceptions.EntityNotFoundException;
import br.com.teste.models.Motorista;
import br.com.teste.models.Status;
import br.com.teste.utils.EntityManagerSingleton;

@Named
@RequestScoped
public class MotoristaBean {
	
	private Motorista motorista = new Motorista();
	private MotoristaDaoImpl dao = new MotoristaDaoImpl
									(EntityManagerSingleton.getInstance());
	public void salvar() {
		
		motorista.setStatus(Status.ATIVO);
		try {
			dao.create(motorista);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
				
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Motorista cadastrado com sucesso!"));
	}
	
	public List<Motorista> getMotoristas(){ 
		try {
			List<Motorista> todos = dao.getAll();
			return todos;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Motorista> getMotoristasAtivos(){ 
		try {
			List<Motorista> ativos = dao.getActive();
			return ativos;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void trocarStatus() {
		Map<String, String> params = FacesContext.
										getCurrentInstance().
											getExternalContext().
												getRequestParameterMap();
		String idString = params.get("id-motorista");
		try {
			Motorista motorista = dao.read(Long.parseLong(idString));
			motorista.setStatus(motorista.getStatus()
									.equals(Status.ATIVO) ?
											Status.INATIVO : Status.ATIVO );
			dao.update(motorista);
			dao.commit();
		} catch (EntityNotFoundException | CommitException e) {
			e.printStackTrace();
		}
		
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	
	
}

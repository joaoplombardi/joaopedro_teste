package br.com.teste.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.teste.dao.impl.PassageiroDaoImpl;
import br.com.teste.exceptions.CommitException;
import br.com.teste.exceptions.EntityNotFoundException;
import br.com.teste.models.Passageiro;
import br.com.teste.utils.EntityManagerSingleton;

@Named
@RequestScoped
public class PassageiroBean {
	private Passageiro passageiro = new Passageiro();
	private PassageiroDaoImpl dao = new PassageiroDaoImpl(EntityManagerSingleton.
															getInstance());
	
	public void salvar() {
		try {
			dao.create(passageiro);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Passageiro cadastrado com sucesso!"));
	}
	
	public List<Passageiro> getPassageiros(){ 
		try {
			List<Passageiro> todos = dao.getAll();
			return todos;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	

}

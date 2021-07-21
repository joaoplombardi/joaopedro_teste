package br.com.teste.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.teste.dao.impl.CorridaDaoImpl;
import br.com.teste.dao.impl.MotoristaDaoImpl;
import br.com.teste.dao.impl.PassageiroDaoImpl;
import br.com.teste.exceptions.CommitException;
import br.com.teste.exceptions.EntityNotFoundException;
import br.com.teste.models.Corrida;
import br.com.teste.utils.EntityManagerSingleton;

@Named
@RequestScoped
public class CorridaBean {
	private Corrida corrida = new Corrida();
	private CorridaDaoImpl daoCorrida = new CorridaDaoImpl(EntityManagerSingleton.getInstance());
	private MotoristaDaoImpl daoMotorista = new MotoristaDaoImpl(EntityManagerSingleton.getInstance());
	private PassageiroDaoImpl daoPassageiro = new PassageiroDaoImpl(EntityManagerSingleton.getInstance());
	private Long idMotorista = 0l; 
	private Long idPassageiro = 0l;
	
	public void salvar() {
		try {
			corrida.setPassageiro(daoPassageiro.read(idPassageiro));
			corrida.setMotorista(daoMotorista.read(idMotorista));
			daoCorrida.create(corrida);
			daoCorrida.commit();
		} catch (CommitException | EntityNotFoundException e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Corrida cadastrada com sucesso!"));
	}
	
	public List<Corrida> getCorridas(){
		try {
			List<Corrida> todas = daoCorrida.getAll();
			return todas;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Corrida getCorrida() {
		return corrida;
	}
	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
	public Long getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}

	public Long getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(Long idPassageiro) {
		this.idPassageiro = idPassageiro;
	}


}

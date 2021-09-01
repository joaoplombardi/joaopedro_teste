package br.com.teste.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_MOTORISTA")
public class Motorista{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_motorista")
	private Long id;
	
	@Column(name = "nm_motorista", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "dt_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	
	@Column(name = "nr_cpf", nullable = false, length = 14)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_sexo", nullable = false, length = 15)
	private Sexo sexo;
	
	@Column(name = "ds_modelo_carro", nullable = false, length = 60)
	private String modeloCarro;
	
	@Column(name = "st_motorista", nullable = false, length = 10)
	private Status status;
	
	@OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Corrida> corridas;
	
	public Motorista() {
	}
	
	
	
	public Motorista(Long id) {
		this.id = id;
	}



	public Motorista(Long id,
					 String nome,
					 Date dtNascimento,
					 String cpf,
					 Sexo sexo,
					 String modeloCarro,
					 Status status) {
		this.id = id;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.modeloCarro = modeloCarro;
		this.status = status;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDtNascimento() {
		return dtNascimento;
	}


	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}
	


	
	
	
}

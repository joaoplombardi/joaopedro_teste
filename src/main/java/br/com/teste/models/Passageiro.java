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
@Table(name = "TB_PASSAGEIRO")
public class Passageiro{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_passageiro")
	private Long id;
	
	@Column(name = "nm_passageiro", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "dt_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	
	@Column(name = "nr_cpf", nullable = false, length = 14)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_sexo", nullable = false, length = 15)
	private Sexo sexo;

	@OneToMany(mappedBy = "passageiro", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Corrida> corridas;
	
	public Passageiro() {
	}
	
	

	public Passageiro(Long id) {
		this.id = id;
	}



	public Passageiro(Long id,
					  String nome,
					  Date dtNascimento,
					  String cpf,
					  Sexo sexo) {
		this.id = id;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
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

}

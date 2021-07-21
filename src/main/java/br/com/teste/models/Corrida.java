package br.com.teste.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "TB_CORRIDA")
public class Corrida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cd_motorista", nullable = false)
	private Motorista motorista;
	
	@ManyToOne
	@JoinColumn(name = "cd_passageiro", nullable = false)
	private Passageiro passageiro;
	
	@Column(name = "vl_corrida")
	private BigDecimal valor;
	
	
	public Corrida() {
	}

	public Corrida(Long id,
				   Motorista motorista,
				   Passageiro passageiro,
				   BigDecimal valor) {
		this.id = id;
		this.motorista = motorista;
		this.passageiro = passageiro;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
	
}

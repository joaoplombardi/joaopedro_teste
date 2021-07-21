package br.com.teste.models;

public enum Sexo {
	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	OUTRO("Outro");
	
	private String value;
	Sexo(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

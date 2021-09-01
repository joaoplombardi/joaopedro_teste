package br.com.teste.models;

public enum Status {
	ATIVO(true, "Ativo"),
	INATIVO(false, "Inativo");
	
	Status(Boolean permissao, String Status) {

	}
	private Boolean permissao;
	private String status;
	
	public String getStatus() {
		return status;
	}
	
	public Boolean isAtivo() {
		return permissao;
	}
	
}

package br.com.teste.exceptions;

public class EntityNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException() {
		super("Entidade não encontrada");
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
	
}

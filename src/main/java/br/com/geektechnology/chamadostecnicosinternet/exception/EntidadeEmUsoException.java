package br.com.geektechnology.chamadostecnicosinternet.exception;

public class EntidadeEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
	
	public EntidadeEmUsoException(Long entidadeId) {
		this(String.format("Não existe um cadastro de PESSOA com código %d", entidadeId));
	}
	
}

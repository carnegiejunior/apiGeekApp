package br.com.geektechnology.chamadostecnicosinternet.exception;

public class ColaboradorNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ColaboradorNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public ColaboradorNaoEncontradaException(Long colaboradorId) {
		this(String.format("Não existe um cadastro de COLABORADOR com código %d", colaboradorId));
	}


}

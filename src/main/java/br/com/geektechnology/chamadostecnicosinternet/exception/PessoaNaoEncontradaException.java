package br.com.geektechnology.chamadostecnicosinternet.exception;

public class PessoaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public PessoaNaoEncontradaException(Long pessoaId) {
		this(String.format("Não existe um cadastro de PESSOA com código %d", pessoaId));
	}


}

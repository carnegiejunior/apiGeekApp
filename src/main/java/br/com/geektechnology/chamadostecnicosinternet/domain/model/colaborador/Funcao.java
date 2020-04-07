package br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador;

public enum Funcao {
	TECNICO("Técnico de campo"),
	ATENDENTE_FRENTE("Atendende de frente de loja"),
	NOC("Network Operation Center");
	
	private String funcao;
	
	Funcao(String funcao){
		this.funcao = funcao;
	}
	
	public String getFuncao() {
		return this.funcao;
	}
}

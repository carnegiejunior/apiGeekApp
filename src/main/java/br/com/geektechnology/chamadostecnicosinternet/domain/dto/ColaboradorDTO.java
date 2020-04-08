package br.com.geektechnology.chamadostecnicosinternet.domain.dto;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Funcao;
import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;
import lombok.Data;

@Data
public class ColaboradorDTO {
	
	private Long id;
	
	private Pessoa pessoa;

	private Funcao funcao;	
	
	
}

package br.com.geektechnology.chamadostecnicosinternet.domain.dto;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.FuncaoClass;
import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;
import lombok.Data;

@Data
public class ColaboradorDTO {
	
	private Long id;
	
	private Pessoa pessoa;

	private FuncaoClass funcao;	
	
	
}

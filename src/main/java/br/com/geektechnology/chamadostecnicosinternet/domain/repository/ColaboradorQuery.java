package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import java.util.List;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;

public interface ColaboradorQuery {
	
	List<Colaborador> findComNomeSemelhante(String nome);
	

}

package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;

public interface ColaboradorQueries {
	
	List<Colaborador> findComNomeSemelhante(String nome);
	Optional<Colaborador> findFirst();
	

}

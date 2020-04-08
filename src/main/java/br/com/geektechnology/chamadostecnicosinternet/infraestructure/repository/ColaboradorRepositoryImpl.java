package br.com.geektechnology.chamadostecnicosinternet.infraestructure.repository;

import static br.com.geektechnology.chamadostecnicosinternet.infraestructure.repository.spec.ColaboradorSpecs.comNomeSemelhante;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.ColaboradorQueries;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.ColaboradorRepository;

@Repository 
public class ColaboradorRepositoryImpl implements ColaboradorQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired @Lazy
	ColaboradorRepository colaboradorRepository;

	@Override
	public List<Colaborador> findComNomeSemelhante(String nome) {
		return this.colaboradorRepository.findAll(comNomeSemelhante(nome));
	}

	@Override
	public Optional<Colaborador> findFirst() {
		return this.colaboradorRepository.buscarPrimeiro();
	}
	
	

}

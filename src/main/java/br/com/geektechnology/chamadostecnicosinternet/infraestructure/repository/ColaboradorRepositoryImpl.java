package br.com.geektechnology.chamadostecnicosinternet.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.ColaboradorQuery;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.ColaboradorRepository;
import br.com.geektechnology.chamadostecnicosinternet.infraestructure.repository.spec.ColaboradorSpecs;

@Repository 
public class ColaboradorRepositoryImpl implements ColaboradorQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired @Lazy
	ColaboradorRepository colaboradorRepository;

	@Override
	public List<Colaborador> findComNomeSemelhante(String nome) {
		return this.colaboradorRepository.findAll(ColaboradorSpecs.comNomeSemelhante(nome));
	}
	

}

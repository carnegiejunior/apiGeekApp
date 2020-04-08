package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;

public interface ColaboradorRepository extends CustomJpaRepository<Colaborador, Long>, ColaboradorQueries, JpaSpecificationExecutor<Colaborador>{
}

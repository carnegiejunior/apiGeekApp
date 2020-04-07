package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.FuncaoClass;


@Repository
public interface IFuncaoColaboradorRepository extends JpaRepository<FuncaoClass, Long> {}

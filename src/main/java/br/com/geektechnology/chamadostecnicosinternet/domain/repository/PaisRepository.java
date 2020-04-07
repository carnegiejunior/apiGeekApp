package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{

}

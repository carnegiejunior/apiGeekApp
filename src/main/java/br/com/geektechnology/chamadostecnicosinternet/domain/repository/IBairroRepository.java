package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco.Bairro;

public interface IBairroRepository extends JpaRepository<Bairro, Long>{

}

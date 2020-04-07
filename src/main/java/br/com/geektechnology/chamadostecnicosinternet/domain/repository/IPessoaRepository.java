package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long>{

	
}

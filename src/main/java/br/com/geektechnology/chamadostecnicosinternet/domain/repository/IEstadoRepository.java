package br.com.geektechnology.chamadostecnicosinternet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco.Estado;
public interface IEstadoRepository extends JpaRepository<Estado, Long>{

}

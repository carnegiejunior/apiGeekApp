package br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pessoas_juridicas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@JsonRootName("PessoasJuridicas")
public class PessoaJuridica {
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
}

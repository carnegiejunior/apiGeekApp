package br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "colaboradores")
@JsonRootName(value = "Colaboradores")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@NotNull
	@Enumerated(EnumType.STRING)
	private FuncaoClass funcao;

}

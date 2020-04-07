package br.com.geektechnology.chamadostecnicosinternet.domain.model.chamado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonRootName("MeiosSolicitacaos")
@Getter
@NoArgsConstructor (force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "meios_solicitacoes")

public class MeioSolicitacao {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  final Long id;
	
	@NotBlank
	@Column(name = "nome", nullable = false, length = 25)
	@JsonProperty(value = "nome")
	private final String nome;
	
}

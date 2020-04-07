package br.com.geektechnology.chamadostecnicosinternet.domain.model.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@JsonRootName("Clientes")
@Table(name = "clientes")
public class Cliente {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private final Long id;

	@NotNull
	@OneToOne
	@JsonProperty("contratante-id")
	@JoinColumn(name = "contratante_id", nullable = false)
	private final Pessoa pessoa;

	@NotBlank
	@JsonProperty("numero-contrato")
	@Column(name = "numero_contrato", nullable = false, length = 20)
	private final String numeroContrato;

	@NotBlank
	@JsonProperty("nas-server")
	@Column(name = "nas_server", nullable = false, length = 50)
	private final String nasServer;
}

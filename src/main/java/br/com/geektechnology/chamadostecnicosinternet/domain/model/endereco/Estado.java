package br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("Estados")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "estados")
public class Estado {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Column(name = "codigo_ibge", nullable = false)
	private byte codigoIBGE;

	@NotBlank
	@Column(name = "sigla", nullable = false, length = 2)
	private String sigla;
	
	@NotBlank
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais paisId;
	
}
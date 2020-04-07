package br.com.geektechnology.chamadostecnicosinternet.domain.model.contato;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("Contatos")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "contatos")
public class Contato {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@Basic
	@Column(name = "descricao", nullable = false)
	@NotBlank
	private  String atributo;
	
	@ManyToOne
	@JoinColumn(name = "tipo_contato_id", nullable = false )
	private  TipoContato tipoContato;
}

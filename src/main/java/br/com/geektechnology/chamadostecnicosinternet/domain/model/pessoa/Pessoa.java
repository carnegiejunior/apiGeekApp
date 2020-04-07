package br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.contato.Contato;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName(value = "Pessoas")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pessoas")
@Entity
public class Pessoa {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", length = 8, nullable = false)
	@NotNull
	private Tipo tipoPessoa;
	
	@Column(name = "observacao", nullable = true)
private  String observacao;


	@OneToMany
	@JsonProperty(value = "contato-pessoa-id")
	@JoinColumn(name = "pessoa_id", nullable = true)
	private List<Contato> contatos;
	

//	@Valid
//	@NotNull
//	@ManyToMany
//	@JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_id","endereco_id"})} , name = "pessoa_endereco", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
//	@JoinColumn(name = "endereco_id")
//	private List<Endereco> enderecos;

}

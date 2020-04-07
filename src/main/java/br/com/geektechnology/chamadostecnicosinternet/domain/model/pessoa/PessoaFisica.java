package br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa;

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

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pessoas_fisicas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@JsonRootName("PessoasFisicas")
public class PessoaFisica {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@CPF
	@NotBlank
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@NotBlank
	@Column(name = "rg", nullable = false, length = 20) 
	private String rg;
	
	@NotBlank
	@Column(name = "nome", nullable = false, length = 51)
	private String nome;
	
	@NotBlank
	@Column(name = "apelido", nullable = false, length = 25)
	private String apelido;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	
}

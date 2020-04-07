package br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("Enderecos")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name =  "enderecos")
public class Endereco {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "cep", length = 8, nullable = false)
//	@NotBlank
//	@Size(min = 8, max = 8)
//	private String cep;
	
	
	
	@Column(name = "logradouro", length = 100, nullable = false)
	@Size(min = 5)
	@NotBlank(message = "Campo não pode ser nulo")
	private String logradouro;
	
//	@Column(name = "numero", nullable = true, length = 20)
//	private String numero;
//	
//	@Column(name = "complemento", nullable = true, length = 100)
//	private String complemento;
//	
//	@Column(name = "bairro", nullable = false, length = 100)
//	private String bairro;
//	
//	@Column(name = "cidade", length = 100, nullable = false)
//	private String cidade;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "endereco_cidade_id")
//	private String cidade;
	
//	@Enumerated(EnumType.STRING)
//	@NotNull
//	private TipoEndereco tipoEndereco;
//
//	@ManyToOne
//	@JoinColumn(name = "logradouro", nullable = false)
//	@NotNull
//	private Logradouro logradouro;
//	
//	@Column(name = "ponto_referencia", nullable = true, length = 200)
//	private String pontoReferencia;	




}

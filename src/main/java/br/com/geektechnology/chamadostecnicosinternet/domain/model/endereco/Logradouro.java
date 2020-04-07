package br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("Logradouros")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name =  "logradouros")
public class Logradouro {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Min(value = 8, message = "${lograouro.cep.menor.que.oito}")
	@Column(nullable = false, length = 8)
	private String cep;
	
	@Column(name = "descricao", nullable = false, length = 100)
	@NotBlank
	private String descricao;

	@Column(name = "complemento", nullable = false, length = 100)
	private String complemento;
	
//	@ManyToOne
//	@JoinColumn(name = "tipo_logradouro_id", nullable = false)
//	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "numero", nullable = true, length = 20)
	@NotBlank
	private String numero;	
	
//	@NotNull
//	@Valid
//	@ManyToOne
//	@JoinColumn(name = "bairro_id", nullable = false)
//	private Bairro bairro;

	@NotBlank
	@Valid
	@Column(name = "bairro",length = 100, nullable = false)
	private String bairro;
	
//	@ManyToOne
//	@JoinColumn(name = "cidade_id", nullable = false)
//	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name = "geolocalizacao_id", nullable = true)
	private GeoLocalizacao geoLocalizacao;

}

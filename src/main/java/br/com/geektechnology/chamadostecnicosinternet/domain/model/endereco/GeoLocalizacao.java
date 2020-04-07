package br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("GeoLocalizacoes")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table( name = "geolocalizacoes")
public class GeoLocalizacao {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "geolocalizacao_id", nullable = false)
	private  Long id;

	@NotBlank
	@Column(name = "latitude", nullable = false)
	private  String latitude;
	
	@NotBlank
	@Column(name = "longitude", nullable = false)
	private String longitude;
}

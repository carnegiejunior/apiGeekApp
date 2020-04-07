package br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonRootName(value = "FuncoesColaboradores")
@Table(name =  "funcoes_colaboradores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FuncaoClass {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 35)
	private String nome;

}

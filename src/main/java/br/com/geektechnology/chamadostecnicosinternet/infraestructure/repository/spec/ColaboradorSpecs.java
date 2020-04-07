package br.com.geektechnology.chamadostecnicosinternet.infraestructure.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ColaboradorSpecs {

	public static Specification<Colaborador> comNomeSemelhante(String nome) {
		return (root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%");
	}
}

package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco.Endereco;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.BairroRepository;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	BairroRepository bairroRepository;

	@Transactional
	public Endereco save(Endereco endereco) {
		//	bairroRepository.save(endereco.getBairro());
			return enderecoRepository.save(endereco);
	}
}

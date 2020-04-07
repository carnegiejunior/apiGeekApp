package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco.Endereco;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.IBairroRepository;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.IEnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	IEnderecoRepository enderecoRepository;

	@Autowired
	IBairroRepository bairroRepository;

	@Transactional
	public Endereco save(Endereco endereco) {
		//	bairroRepository.save(endereco.getBairro());
			return enderecoRepository.save(endereco);
	}
}

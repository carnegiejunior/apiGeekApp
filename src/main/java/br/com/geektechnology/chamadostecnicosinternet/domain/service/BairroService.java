package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.endereco.Bairro;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.BairroRepository;

@Service
public class BairroService {

	@Autowired
	BairroRepository bairroRepository;

	@Transactional
	public Bairro save(Bairro bairro) {
		return bairroRepository.save(bairro);
	}
}

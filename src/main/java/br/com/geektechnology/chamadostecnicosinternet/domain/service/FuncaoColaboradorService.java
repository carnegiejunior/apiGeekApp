package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.FuncaoClass;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.IFuncaoColaboradorRepository;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeNaoEncontradaException;

@Service
public class FuncaoColaboradorService {

	@Autowired
	IFuncaoColaboradorRepository funcaoColaboradorRepository;

	public List<FuncaoClass> findAll() {
		return funcaoColaboradorRepository.findAll();
	}

	public FuncaoClass save(FuncaoClass funcao) {
		return this.funcaoColaboradorRepository.save(funcao);
	}
	
	public void delete(Long funcaoId) {
		try {
			this.funcaoColaboradorRepository.deleteById(funcaoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de função com código %d", funcaoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Função de código %d não pode ser removido, pois está em uso", funcaoId));
		}
	}

	public Optional<FuncaoClass> findById(Long funcaoId) {
		return this.funcaoColaboradorRepository.findById(funcaoId);
	}
	
	
}

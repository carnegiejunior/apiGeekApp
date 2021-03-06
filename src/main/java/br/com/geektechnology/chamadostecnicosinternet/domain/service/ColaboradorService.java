package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.ColaboradorRepository;
import br.com.geektechnology.chamadostecnicosinternet.exception.ColaboradorNaoEncontradaException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;

@Service
public class ColaboradorService {

	private static final String MSG_COLABORADOR_EM_USO = "Colaborador de código %d não pode ser removido, pois está em uso";

	@Autowired
	ColaboradorRepository colaboradorRepository;

	@Autowired
	PessoaService pessoaService;


	public List<Colaborador> findAll() {
		return this.colaboradorRepository.findAll();
	}
	
	public Optional<Colaborador> findFirst() {
		return this.colaboradorRepository.buscarPrimeiro();
	}

	@Transactional
	public Colaborador save(Colaborador colaborador) {
		mergePessoaColaborador(colaborador);
		return this.colaboradorRepository.save(colaborador);
	}


	private void mergePessoaColaborador(Colaborador colaborador) {
		Optional.ofNullable(colaborador.getPessoa().getId())
			.ifPresent( (pessoaId) -> this.pessoaService.findById(pessoaId).ifPresent(	(pessoa) -> colaborador.setPessoa(pessoa)));
		 this.pessoaService.save(colaborador.getPessoa());
	}

	@Transactional
	public void delete(Long colaboradorId) {
		try {

			colaboradorRepository.deleteById(colaboradorId);
			colaboradorRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ColaboradorNaoEncontradaException(colaboradorId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_COLABORADOR_EM_USO, colaboradorId));
		}
	}

	public Optional<Colaborador> findById(Long colaboradorId) {
		return Optional.ofNullable(
				this.colaboradorRepository.findById(colaboradorId).orElseThrow(
						() -> new ColaboradorNaoEncontradaException(colaboradorId)
						));
	}

	public List<Colaborador> findComNomeSemelhante(String nome) {
		return this.colaboradorRepository.findComNomeSemelhante(nome);
	}

}

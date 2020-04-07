package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.IPessoaRepository;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.PessoaNaoEncontradaException;

@Service
public class PessoaService {
	
	private static final String MSG_PESSOA_EM_USO 
	= "Pessoa de código %d não pode ser removido, pois está em uso";

	@Autowired
	IPessoaRepository pessoaRepository;

	@Autowired
	EnderecoService enderecoService;
	
	public List<Pessoa> findAll(){
		return this.pessoaRepository.findAll();
	}
	
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		//pessoa.getEnderecos().forEach((endereco)->{this.enderecoService.save(endereco);});
		return this.pessoaRepository.save(pessoa);
	}

	@Transactional
	public void delete(Long pessoaId) {
		try {

			pessoaRepository.deleteById(pessoaId);
			pessoaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new PessoaNaoEncontradaException(pessoaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_PESSOA_EM_USO, pessoaId));
		}
	}

	public Optional<Pessoa> findById(Long pessoaId) {
		return this.pessoaRepository.findById(pessoaId);
		
//		return Optional.ofNullable(
//				this.pessoaRepository.findById(pessoaId).orElseThrow(
//						() -> new PessoaNaoEncontradaException(pessoaId)
//						));
	}	
	

}

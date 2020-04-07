package br.com.geektechnology.chamadostecnicosinternet.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.chamado.Chamado;
import br.com.geektechnology.chamadostecnicosinternet.domain.repository.IChamadoRepository;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeNaoEncontradaException;

@Service
public class ChamadoService {

	@Autowired
	private IChamadoRepository chamadoRepository;

	public List<Chamado> findAll() {
		return this.chamadoRepository.findAll();
	}

	public Chamado save(Chamado chamado) {
		return this.chamadoRepository.save(chamado);
	}

	public void delete(Long chamadoId) {
		try {
			chamadoRepository.deleteById(chamadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de chamado com código %d", chamadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Chamado de código %d não pode ser removido, pois está em uso", chamadoId));
		}
	}

	public Optional<Chamado> findById(Long chamadoId) {
		return this.chamadoRepository.findById(chamadoId);
	}


//	private void mergeFieldsForPreparePartialUpdate(Chamado chamado, String fieldProperty, Object fieldValue) {
//		Field field = ReflectionUtils.findField(Chamado.class, fieldProperty);
//		Optional.of(field).ifPresent(fieldParam -> {
//			fieldParam.setAccessible(true);
//			ReflectionUtils.setField(fieldParam, chamado, fieldValue);
//		});
//	}
}

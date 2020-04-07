package br.com.geektechnology.chamadostecnicosinternet.api.v1.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.chamado.Chamado;
import br.com.geektechnology.chamadostecnicosinternet.domain.service.ChamadoService;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeNaoEncontradaException;



@RestController
@RequestMapping(value = "/v1/chamados")
public class ChamadoController {

	@Autowired
	private ChamadoService chamadoService;

	@GetMapping
	public List<Chamado> findAll() {
		return this.chamadoService.findAll();
	}

	@GetMapping("/{chamadoId}")
	public ResponseEntity<Chamado> findById(@PathVariable Long chamadoId) {
		Optional<Chamado> chamado = this.chamadoService.findById(chamadoId);
		if (chamado.isPresent()) {
			return ResponseEntity.ok(chamado.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Chamado chamado) {
		try {
			chamado = chamadoService.save(chamado);
			return ResponseEntity.status(HttpStatus.CREATED).body(chamado);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{chamadoId}")
	public ResponseEntity<Chamado> update(@PathVariable Long chamadoId, @RequestBody Chamado chamado) {
		Optional<Chamado> chamadoAtual = chamadoService.findById(chamadoId);
		if (chamadoAtual.isPresent()) {
			BeanUtils.copyProperties(chamado, chamadoAtual.get(), "id","dataHoraAberturaChamado");
			Chamado chamadoSalva = chamadoService.save(chamadoAtual.get());
			return ResponseEntity.ok(chamadoSalva);
		}
		return ResponseEntity.notFound().build();
	}

	// Rever esta opção..
	@PatchMapping(value = "/{chamadoId}")
	public ResponseEntity<?> partialUpdate(@PathVariable Long chamadoId, @RequestBody Map<String, Object> campos) {

//		Chamado chamadoAtual = this.chamadoService.findById(chamadoId)
//				.orElseThrow(() -> new EntidadeNaoEncontradaException(
//						String.format("Erro em prepareForPartialUpdate: O chamado com código %d", chamadoId)));
		Chamado chamadoAtual = this.chamadoService.findById(chamadoId).get();
		if (chamadoAtual == null) {
			return ResponseEntity.notFound().build();
		}
		merge(campos, chamadoAtual);

		return this.update(chamadoId, chamadoAtual);

	}

	private void merge(Map<String, Object> dadosOrigem, Chamado chamadoDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Chamado chamadoOrigem = objectMapper.convertValue(dadosOrigem, Chamado.class);

		dadosOrigem.forEach((fieldProperty, fieldValue) -> {
			Field field = ReflectionUtils.findField(Chamado.class, fieldProperty);
			if (field != null) {
				field.setAccessible(true);
				Object fieldNewValue = ReflectionUtils.getField(field, chamadoOrigem);
				System.out.println(fieldProperty + " = " + fieldValue + " = " + fieldNewValue);
				ReflectionUtils.setField(field, chamadoDestino, fieldNewValue);
			}
		});
	}

	@DeleteMapping("/{chamadoId}")
	public ResponseEntity<?> delete(@PathVariable Long chamadoId) {
		try {
			this.chamadoService.delete(chamadoId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}

package br.com.geektechnology.chamadostecnicosinternet.api.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.Colaborador;
import br.com.geektechnology.chamadostecnicosinternet.domain.service.ColaboradorService;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeNaoEncontradaException;

@RestController
@RequestMapping(value = "/v1/colaboradores")
public class ColaboradorController {

	@Autowired
	ColaboradorService colaboradorService;
	
	@GetMapping
	public List<Colaborador> findAll() {
		return this.colaboradorService.findAll();
	}

	@GetMapping("/{colaboradorId}")
	public ResponseEntity<Colaborador> findById(@PathVariable Long colaboradorId) {
		Optional<Colaborador> colaborador = this.colaboradorService.findById(colaboradorId);
		if (colaborador.isPresent()) {
			return ResponseEntity.ok(colaborador.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Colaborador colaborador) {
		try {
			colaborador = this.colaboradorService.save(colaborador);
			return ResponseEntity.status(HttpStatus.CREATED).body(colaborador);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{colaboradorId}")
	public ResponseEntity<Colaborador> update(@PathVariable Long colaboradorId, @RequestBody Colaborador colaborador) {
		Optional<Colaborador> colaboradorAtual = colaboradorService.findById(colaboradorId);
		if (colaboradorAtual.isPresent()) {
			BeanUtils.copyProperties(colaborador, colaboradorAtual.get(), "id");
			Colaborador colaboradorSalva = colaboradorService.save(colaboradorAtual.get());
			return ResponseEntity.ok(colaboradorSalva);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{colaboradorId}")
	public ResponseEntity<?> delete(@PathVariable Long colaboradorId) {
		try {
			this.colaboradorService.delete(colaboradorId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
		
	
}

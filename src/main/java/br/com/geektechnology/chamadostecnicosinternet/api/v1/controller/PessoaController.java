package br.com.geektechnology.chamadostecnicosinternet.api.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geektechnology.chamadostecnicosinternet.domain.model.pessoa.Pessoa;
import br.com.geektechnology.chamadostecnicosinternet.domain.service.PessoaService;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeNaoEncontradaException;

@RestController
@RequestMapping(value = "/v1/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> findAll() {
		return this.pessoaService.findAll();
	}

	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long pessoaId) {
		Optional<Pessoa> pessoa = this.pessoaService.findById(pessoaId);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Pessoa pessoa) {
		try {
			pessoa = this.pessoaService.save(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> update(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaAtual = pessoaService.findById(pessoaId);
		if (pessoaAtual.isPresent()) {
			BeanUtils.copyProperties(pessoa, pessoaAtual.get(), "id");
			Pessoa pessoaSalva = pessoaService.save(pessoaAtual.get());
			return ResponseEntity.ok(pessoaSalva);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<?> delete(@PathVariable Long pessoaId) {
		try {
			this.pessoaService.delete(pessoaId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	
	
	
}

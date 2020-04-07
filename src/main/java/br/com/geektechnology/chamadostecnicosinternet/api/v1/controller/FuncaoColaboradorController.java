package br.com.geektechnology.chamadostecnicosinternet.api.v1.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.geektechnology.chamadostecnicosinternet.domain.model.colaborador.FuncaoClass;
import br.com.geektechnology.chamadostecnicosinternet.domain.service.FuncaoColaboradorService;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeEmUsoException;
import br.com.geektechnology.chamadostecnicosinternet.exception.EntidadeNaoEncontradaException;

@RestController
@RequestMapping(value = "/v1/funcoescolaboradores")
public class FuncaoColaboradorController {
	
	@Autowired
	FuncaoColaboradorService funcaoColaboradorService;
	
	@GetMapping
	public List<FuncaoClass> findAll() {
		return this.funcaoColaboradorService.findAll();
	}
	
	@GetMapping("/{funcaoId}")
	public ResponseEntity<FuncaoClass> findById(@PathVariable Long funcaoId) {
		Optional<FuncaoClass> funcao = this.funcaoColaboradorService.findById(funcaoId);
		if (funcao.isPresent()) {
			return ResponseEntity.ok(funcao.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody FuncaoClass funcao) {
		try {
			funcao = this.funcaoColaboradorService.save(funcao);
			return ResponseEntity.status(HttpStatus.CREATED).body(funcao);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{funcaoId}")
	public ResponseEntity<FuncaoClass> update(@PathVariable Long funcaoId, @RequestBody FuncaoClass funcao) {
		Optional<FuncaoClass> funcaoAtual = funcaoColaboradorService.findById(funcaoId);
		if (funcaoAtual.isPresent()) {
			BeanUtils.copyProperties(funcao, funcaoAtual.get(), "id");
			FuncaoClass funcaoSalva = funcaoColaboradorService.save(funcaoAtual.get());
			return ResponseEntity.ok(funcaoSalva);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{funcaoId}")
	public ResponseEntity<?> delete(@PathVariable Long funcaoId) {
		try {
			this.funcaoColaboradorService.delete(funcaoId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
}

package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.dto.PublicacaoDTO;
import org.generation.blogPessoal.model.Publicacao;
import org.generation.blogPessoal.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PublicacaoController {
	
	@Autowired
	private PublicacaoService service;
	
	@GetMapping
	public ResponseEntity<List<PublicacaoDTO>> getAll() {
		Optional<List<PublicacaoDTO>> publicacoes = service.getAll();
		return ResponseEntity.ok(publicacoes.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PublicacaoDTO> getById(@PathVariable long id) {
		return service.getById(id)
				.map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Optional<List<PublicacaoDTO>>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(service.getByTitulo(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Optional<PublicacaoDTO>> post(@RequestBody Publicacao publicacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.post(publicacao));
	}
	
	@PutMapping
	public ResponseEntity<Optional<PublicacaoDTO>> put(@RequestBody Publicacao publicacao) {
		return ResponseEntity.status(HttpStatus.OK).body(service.put(publicacao));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}
}

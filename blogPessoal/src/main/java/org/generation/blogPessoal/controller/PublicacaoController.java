package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.dto.PublicacaoDTO;
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
	public ResponseEntity<Optional<List<PublicacaoDTO>>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PublicacaoDTO>> getById(@PathVariable long id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Optional<List<PublicacaoDTO>>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(service.getByTitulo(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Optional<PublicacaoDTO>> post(@RequestBody PublicacaoDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.post(dto));
	}
	
	@PutMapping
	public ResponseEntity<Optional<PublicacaoDTO>> put(@RequestBody PublicacaoDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.put(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

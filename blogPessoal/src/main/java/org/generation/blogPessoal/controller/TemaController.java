package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.dto.TemaDTO;
import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.service.TemaService;
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
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaService service;
	
	@GetMapping
	public ResponseEntity<List<TemaDTO>> getAll() {
		Optional<List<TemaDTO>> temas = service.getAll();
		return ResponseEntity.ok(temas.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaDTO> getById(@PathVariable long id) {
		return service.getById(id)
				.map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<Optional<List<TemaDTO>>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(service.getByTema(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Optional<TemaDTO>> post(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.post(tema));
	}
	
	@PutMapping
	public ResponseEntity<Optional<TemaDTO>> put(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.OK).body(service.put(tema));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}
}

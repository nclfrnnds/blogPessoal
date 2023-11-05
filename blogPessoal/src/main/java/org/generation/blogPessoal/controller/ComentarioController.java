package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Comentario;
import org.generation.blogPessoal.repository.ComentarioRepository;
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
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository repository;
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Comentario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> getById(@PathVariable long id) {
		return repository.findById(id)
				.map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Comentario> post(@RequestBody Comentario comentario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
	}
	
	@PutMapping
	public ResponseEntity<Comentario> put(@RequestBody Comentario comentario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(comentario));
	}

}

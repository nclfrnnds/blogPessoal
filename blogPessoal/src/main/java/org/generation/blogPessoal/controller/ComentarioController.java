package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.dto.ComentarioDTO;
import org.generation.blogPessoal.model.Comentario;
import org.generation.blogPessoal.service.ComentarioService;
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
	private ComentarioService service;
	
	@GetMapping
	public ResponseEntity<List<ComentarioDTO>> getAll() {
		Optional<List<ComentarioDTO>> comentarios = service.getAll();
		return ResponseEntity.ok(comentarios.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComentarioDTO> getById(@PathVariable long id) {
		return service.getById(id)
				.map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Optional<ComentarioDTO>> post(@RequestBody Comentario comentario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.post(comentario));
	}
	
	@PutMapping
	public ResponseEntity<Optional<ComentarioDTO>> put(@RequestBody Comentario comentario) {
		return ResponseEntity.status(HttpStatus.OK).body(service.put(comentario));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}
}

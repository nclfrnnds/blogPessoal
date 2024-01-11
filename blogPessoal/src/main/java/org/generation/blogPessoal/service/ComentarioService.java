package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Comentario;
import org.generation.blogPessoal.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository repository;

	public Optional<List<Comentario>> getAll() {
		return Optional.of(repository.findAll());
	}
	
	public Optional<Comentario> getById(@PathVariable long id) {
		return repository.findById(id);
	}
	
	public Optional<Comentario> post(@RequestBody Comentario comentario) {
		return Optional.of(repository.save(comentario));
	}
	
	public Optional<Comentario> put(@RequestBody Comentario comentario) {
		return Optional.of(repository.save(comentario));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

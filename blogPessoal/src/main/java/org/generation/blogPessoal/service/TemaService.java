package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TemaService {
	
	@Autowired
	private TemaRepository repository;
	
	public Optional<List<Tema>> getAll() {
		return Optional.of(repository.findAll());
	}
	
	public Optional<Tema> getById(@PathVariable long id) {
		return repository.findById(id);
	}
	
	public Optional<List<Tema>> getByTema(@PathVariable String tema) {
		return Optional.of(repository.findAllByDescricaoContainingIgnoreCase(tema));
	}
	
	public Optional<Tema> post(@RequestBody Tema tema) {
		return Optional.of(repository.save(tema));
	}
	
	public Optional<Tema> put(@RequestBody Tema tema) {
		return Optional.of(repository.save(tema));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

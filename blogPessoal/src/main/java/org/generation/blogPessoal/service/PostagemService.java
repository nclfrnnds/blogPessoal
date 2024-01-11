package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PostagemService {
	
	@Autowired
	private PostagemRepository repository;

	public Optional<List<Postagem>> getAll() {
		return Optional.of(repository.findAll());
	}
	
	public Optional<Postagem> getById(@PathVariable long id) {
		return repository.findById(id);
	}
	
	public Optional<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return Optional.of(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	public Optional<Postagem> post(@RequestBody Postagem postagem) {
		return Optional.of(repository.save(postagem));
	}
	
	public Optional<Postagem> put(@RequestBody Postagem postagem) {
		return Optional.of(repository.save(postagem));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

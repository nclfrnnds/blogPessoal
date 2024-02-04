package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Publicacao;
import org.generation.blogPessoal.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PublicacaoService {
	
	@Autowired
	private PublicacaoRepository repository;

	public Optional<List<Publicacao>> getAll() {
		return Optional.of(repository.findAll());
	}
	
	public Optional<Publicacao> getById(@PathVariable long id) {
		return repository.findById(id);
	}
	
	public Optional<List<Publicacao>> getByTitulo(@PathVariable String titulo) {
		return Optional.of(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	public Optional<Publicacao> post(@RequestBody Publicacao publicacao) {
		return Optional.of(repository.save(publicacao));
	}
	
	public Optional<Publicacao> put(@RequestBody Publicacao publicacao) {
		return Optional.of(repository.save(publicacao));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

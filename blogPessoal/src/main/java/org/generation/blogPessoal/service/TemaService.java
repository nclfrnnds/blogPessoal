package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.generation.blogPessoal.dto.TemaDTO;
import org.generation.blogPessoal.mapper.TemaMapper;
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
	
	public Optional<List<TemaDTO>> getAll() {
		List<Tema> temas = repository.findAll();
		return Optional.of(temas.stream().map(TemaMapper::toDTO).collect(Collectors.toList()));
	}
	
	public Optional<TemaDTO> getById(@PathVariable long id) {
		Optional<Tema> tema = repository.findById(id);
		return Optional.of(TemaMapper.toDTO(tema.get()));
	}
	
	public Optional<List<TemaDTO>> getByTema(@PathVariable String tema) {
		List<Tema> temas = repository.findAllByDescricaoContainingIgnoreCase(tema);
		return Optional.of(temas.stream().map(TemaMapper::toDTO).collect(Collectors.toList()));
	}
	
	public Optional<TemaDTO> post(@RequestBody Tema tema) {
		return Optional.of(TemaMapper.toDTO(repository.save(tema)));
	}
	
	public Optional<TemaDTO> put(@RequestBody Tema tema) {
		return Optional.of(TemaMapper.toDTO(repository.save(tema)));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

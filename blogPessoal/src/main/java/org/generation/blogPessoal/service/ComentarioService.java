package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.generation.blogPessoal.dto.ComentarioDTO;
import org.generation.blogPessoal.mapper.ComentarioMapper;
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

	public Optional<List<ComentarioDTO>> getAll() {
		List<Comentario> comentarios = repository.findAll();
		return Optional.of(comentarios.stream()
			.map(ComentarioMapper::toDTO)
			.collect(Collectors.toList()));
	}
	
	public Optional<ComentarioDTO> getById(@PathVariable long id) {
		Optional<Comentario> comentario = repository.findById(id);
		return Optional.of(ComentarioMapper.toDTO(comentario.get()));
	}
	
	public Optional<ComentarioDTO> post(@RequestBody ComentarioDTO dto) {
		Comentario comentario = ComentarioMapper.toModel(dto);
		return Optional.of(ComentarioMapper.toDTO(repository.save(comentario)));
	}
	
	public Optional<ComentarioDTO> put(@RequestBody ComentarioDTO dto) {
		Comentario comentario = ComentarioMapper.toModel(dto);
		return Optional.of(ComentarioMapper.toDTO(repository.save(comentario)));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}

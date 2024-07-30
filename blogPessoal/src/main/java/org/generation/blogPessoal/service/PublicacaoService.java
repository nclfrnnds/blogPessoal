package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.generation.blogPessoal.dto.PublicacaoDTO;
import org.generation.blogPessoal.mapper.PublicacaoMapper;
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

	public Optional<List<PublicacaoDTO>> getAll() {
		List<Publicacao> publicacoes = repository.findAll();
		return Optional.of(publicacoes.stream()
			.map(PublicacaoMapper::toDTO)
			.collect(Collectors.toList()));
	}
	
	public Optional<PublicacaoDTO> getById(@PathVariable long id) {
		Optional<Publicacao> publicacao = repository.findById(id);
		return Optional.of(PublicacaoMapper.toDTO(publicacao.get()));
	}
	
	public Optional<List<PublicacaoDTO>> getByTitulo(@PathVariable String titulo) {
		List<Publicacao> publicacoes = repository.findAllByTituloContainingIgnoreCase(titulo);
		return Optional.of(publicacoes.stream().map(PublicacaoMapper::toDTO).collect(Collectors.toList()));
	}
	
	public Optional<PublicacaoDTO> post(@RequestBody PublicacaoDTO dto) {
		Publicacao publicacao = PublicacaoMapper.toModel(dto);
		return Optional.of(PublicacaoMapper.toDTO(repository.save(publicacao)));
	}
	
	public Optional<PublicacaoDTO> put(@RequestBody PublicacaoDTO dto) {
		Publicacao publicacao = PublicacaoMapper.toModel(dto);
		return Optional.of(PublicacaoMapper.toDTO(repository.save(publicacao)));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}

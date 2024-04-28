package org.generation.blogPessoal.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.generation.blogPessoal.dto.PublicacaoDTO;
import org.generation.blogPessoal.dto.TemaDTO;
import org.generation.blogPessoal.model.Publicacao;
import org.generation.blogPessoal.model.Tema;

public class TemaMapper {

  public static Tema toModel(TemaDTO temaDTO) {
	  List<Publicacao> publicacao = temaDTO.getPublicacoes().stream()
			  .map(PublicacaoMapper::toModel).collect(Collectors.toList());
	  	  
    return new Tema(temaDTO.getId(), temaDTO.getDescricao(), publicacao);
  }

  public static TemaDTO toDTO(Tema tema) {
	  List<PublicacaoDTO> publicacaoDTO = tema.getPublicacoes().stream()
			  .map(PublicacaoMapper::toDTO).collect(Collectors.toList());
	  
    return new TemaDTO(tema.getId(), tema.getDescricao(), publicacaoDTO);
  }
}

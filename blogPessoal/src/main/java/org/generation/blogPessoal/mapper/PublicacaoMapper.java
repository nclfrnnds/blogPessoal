package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.PublicacaoDTO;
import org.generation.blogPessoal.model.Publicacao;

public class PublicacaoMapper {

  public static PublicacaoDTO toDTO(Publicacao publicacao) {
    return new PublicacaoDTO(publicacao.getId(),
      publicacao.getTitulo(),
      publicacao.getTexto(),
      publicacao.getData(),
      TemaMapper.toDTO(publicacao.getTema()),
      UsuarioMapper.toDTO(publicacao.getUsuario()));
  }
}

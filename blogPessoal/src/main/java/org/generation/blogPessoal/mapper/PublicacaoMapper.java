package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.PublicacaoDTO;
import org.generation.blogPessoal.model.Publicacao;

public class PublicacaoMapper {

  public static Publicacao toModel(PublicacaoDTO publicacaoDTO) {
    return new Publicacao(publicacaoDTO.getId(), publicacaoDTO.getTitulo(),
      publicacaoDTO.getTexto(), publicacaoDTO.getData(),
      TemaMapper.toModel(publicacaoDTO.getTema()),
      UsuarioMapper.toModel(publicacaoDTO.getUsuario()));
  }

  public static PublicacaoDTO toDTO(Publicacao publicacao) {
    return new PublicacaoDTO(publicacao.getId(), publicacao.getTitulo(),
      publicacao.getTexto(), publicacao.getData(),
      TemaMapper.toDTO(publicacao.getTema()),
      UsuarioMapper.toDTO(publicacao.getUsuario()));
  }
}

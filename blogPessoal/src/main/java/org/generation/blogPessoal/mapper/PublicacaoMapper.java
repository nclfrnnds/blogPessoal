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

  public static Publicacao toModel(PublicacaoDTO publicacaoDTO) {
    Publicacao publicacao = new Publicacao();
    publicacao.setId(publicacaoDTO.getId());
    publicacao.setTitulo(publicacaoDTO.getTitulo());
    publicacao.setTexto(publicacaoDTO.getTexto());
    publicacao.setData(publicacaoDTO.getData());
    publicacao.setTema(TemaMapper.toModel(publicacaoDTO.getTema()));
    publicacao.setUsuario(UsuarioMapper.toModel(publicacaoDTO.getUsuario()));
    return publicacao;
  }

}

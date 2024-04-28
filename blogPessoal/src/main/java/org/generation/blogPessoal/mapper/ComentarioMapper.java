package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.ComentarioDTO;
import org.generation.blogPessoal.model.Comentario;

public class ComentarioMapper {

  public static Comentario toModel(ComentarioDTO comentarioDTO) {
    return new Comentario(comentarioDTO.getId(), comentarioDTO.getTexto(),
      comentarioDTO.getData(), UsuarioMapper.toModel(comentarioDTO.getUsuario()),
      PublicacaoMapper.toModel(comentarioDTO.getPublicacao()));
  }

  public static ComentarioDTO toDTO(Comentario comentario) {
    return new ComentarioDTO(comentario.getId(), comentario.getTexto(),
      comentario.getData(), UsuarioMapper.toDTO(comentario.getUsuario()),
      PublicacaoMapper.toDTO(comentario.getPublicacao()));
  }
}

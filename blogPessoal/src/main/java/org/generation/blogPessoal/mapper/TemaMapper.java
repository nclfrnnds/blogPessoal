package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.TemaDTO;
import org.generation.blogPessoal.model.Tema;

public class TemaMapper {

  public static TemaDTO toDTO(Tema tema) {
    return new TemaDTO(tema.getId(),
      tema.getDescricao());
  }

  public static Tema toModel(TemaDTO temaDTO) {
    Tema tema = new Tema();
    tema.setId(temaDTO.getId());
    tema.setDescricao(temaDTO.getDescricao());
    return tema;
  }

}

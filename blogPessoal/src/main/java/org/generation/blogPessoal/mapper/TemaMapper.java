package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.TemaDTO;
import org.generation.blogPessoal.model.Tema;

public class TemaMapper {

  public static Tema toModel(TemaDTO temaDTO) {
    return new Tema(temaDTO.getId(), temaDTO.getDescricao());
  }

  public static TemaDTO toDTO(Tema tema) {
    return new TemaDTO(tema.getId(), tema.getDescricao());
  }
}

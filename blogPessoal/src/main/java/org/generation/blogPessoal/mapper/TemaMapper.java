package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.TemaDTO;
import org.generation.blogPessoal.model.Tema;

public class TemaMapper {

  public static TemaDTO toDTO(Tema tema) {
    return new TemaDTO(tema.getId(), tema.getDescricao());
  }
}

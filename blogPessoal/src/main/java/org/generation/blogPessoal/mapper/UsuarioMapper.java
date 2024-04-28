package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.UsuarioDTO;
import org.generation.blogPessoal.model.Usuario;

public class UsuarioMapper {

  public static UsuarioDTO toDTO(Usuario usuario) {
    return new UsuarioDTO(usuario.getId(), usuario.getNome(),
      usuario.getNomeDeUsuario(), usuario.getSenha(),
      usuario.getFoto(), usuario.getTipo());
  }
}

package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.UsuarioDTO;
import org.generation.blogPessoal.model.Usuario;

public class UsuarioMapper {

  public static Usuario toModel(UsuarioDTO usuarioDTO) {
    return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(),
      usuarioDTO.getNomeDeUsuario(), usuarioDTO.getSenha(),
      usuarioDTO.getFoto(), usuarioDTO.getTipo());
  }

  public static UsuarioDTO toDTO(Usuario usuario) {
    return new UsuarioDTO(usuario.getId(), usuario.getNome(),
      usuario.getNomeDeUsuario(), usuario.getSenha(),
      usuario.getFoto(), usuario.getTipo());
  }
}

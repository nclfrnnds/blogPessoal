package org.generation.blogPessoal.mapper;

import org.generation.blogPessoal.dto.UsuarioDTO;
import org.generation.blogPessoal.model.Usuario;

public class UsuarioMapper {

  public static UsuarioDTO toDTO(Usuario usuario) {
    return new UsuarioDTO(usuario.getId(),
      usuario.getNome(),
      usuario.getNomeDeUsuario(),
      usuario.getSenha(),
      usuario.getFoto(),
      usuario.getTipo());
  }

  public static Usuario toModel(UsuarioDTO usuarioDTO) {
    Usuario usuario = new Usuario();
    usuario.setId(usuarioDTO.getId());
    usuario.setNome(usuarioDTO.getNome());
    usuario.setNomeDeUsuario(usuarioDTO.getNomeDeUsuario());
    usuario.setSenha(usuarioDTO.getSenha());
    usuario.setFoto(usuarioDTO.getFoto());
    usuario.setTipo(usuarioDTO.getTipo());
    return usuario;
  }

}

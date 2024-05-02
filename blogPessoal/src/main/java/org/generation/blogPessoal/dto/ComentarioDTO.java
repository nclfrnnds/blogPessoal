package org.generation.blogPessoal.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDTO {
	
	private long id;

	private String texto;

	private Date data = new java.sql.Date(System.currentTimeMillis());

	private UsuarioDTO usuario;

	private PublicacaoDTO publicacao;

	public ComentarioDTO(long id,
						 String texto,
						 Date data,
						 UsuarioDTO usuario,
						 PublicacaoDTO publicacao) {
		this.id = id;
		this.texto = texto;
		this.data = data;
		this.usuario = usuario;
		this.publicacao = publicacao;
	}

	public ComentarioDTO(ComentarioDTO comentarioDTO) {
		this.id = comentarioDTO.id;
		this.texto = comentarioDTO.texto;
		this.data = comentarioDTO.data;
		this.usuario = comentarioDTO.usuario;
		this.publicacao = comentarioDTO.publicacao;
	}

}

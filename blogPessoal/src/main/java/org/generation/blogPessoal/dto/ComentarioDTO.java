package org.generation.blogPessoal.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
public class ComentarioDTO {
	
	private long id;

	private String texto;

	private Date data = new java.sql.Date(System.currentTimeMillis());

	@JsonIgnoreProperties({ "comentarios", "publicacoes" })
	private UsuarioDTO usuario;

	@JsonIgnoreProperties({ "comentarios", "usuario" })
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

}

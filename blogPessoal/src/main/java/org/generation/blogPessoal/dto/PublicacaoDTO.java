package org.generation.blogPessoal.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicacaoDTO {
	
	private long id;
	
	private String titulo;
	
	private String texto;
	
	private Date data = new java.sql.Date(System.currentTimeMillis());

	private TemaDTO tema;

	private UsuarioDTO usuario;

	private List<ComentarioDTO> comentarios;

	public PublicacaoDTO(long id,
						 String titulo,
						 String texto,
						 Date data,
						 TemaDTO tema,
						 UsuarioDTO usuario) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.tema = tema;
		this.usuario = usuario;
	}

	public PublicacaoDTO(long id,
						 String titulo,
						 String texto,
						 Date data,
						 TemaDTO tema,
						 UsuarioDTO usuario,
						 List<ComentarioDTO> comentarios) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.tema = tema;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

}

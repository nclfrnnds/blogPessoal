package org.generation.blogPessoal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

public class ComentarioDTO {
	
	private long id;

	private String texto;

	private Date data = new java.sql.Date(System.currentTimeMillis());

	@JsonIgnoreProperties({ "comentarios", "publicacoes" })
	private UsuarioDTO usuario;

	@JsonIgnoreProperties({ "comentarios", "usuario" })
	private PublicacaoDTO publicacao;

	public ComentarioDTO() {
	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public PublicacaoDTO getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(PublicacaoDTO publicacao) {
		this.publicacao = publicacao;
	}

}

package org.generation.blogPessoal.dto;

import java.util.Date;

public class ComentarioDTO {
	
	private long id;

	private String texto;

	private Date data = new java.sql.Date(System.currentTimeMillis());

	private UsuarioDTO usuario;

	private PublicacaoDTO publicacao;

	public ComentarioDTO() {
	}

	public ComentarioDTO(long id, String texto, Date data, UsuarioDTO usuario, PublicacaoDTO publicacao) {
		this.id = id;
		this.texto = texto;
		this.data = data;
		this.usuario = usuario;
		this.publicacao = publicacao;
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

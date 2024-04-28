package org.generation.blogPessoal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

public class PublicacaoDTO {
	
	private long id;
	
	private String titulo;
	
	private String texto;
	
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@JsonIgnoreProperties("publicacoes")
	private TemaDTO tema;

	@JsonIgnoreProperties({"publicacoes", "comentarios"})
	private UsuarioDTO usuario;

	@JsonIgnoreProperties({"publicacao"})
	private List<ComentarioDTO> comentarios;

	public PublicacaoDTO() {
	}

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

	public PublicacaoDTO(PublicacaoDTO publicacaoDTO) {
		this.id = publicacaoDTO.id;
		this.titulo = publicacaoDTO.titulo;
		this.texto = publicacaoDTO.texto;
		this.data = publicacaoDTO.data;
		this.tema = publicacaoDTO.tema;
		this.usuario = publicacaoDTO.usuario;
		this.comentarios = publicacaoDTO.comentarios;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public TemaDTO getTema() {
		return tema;
	}
	
	public void setTema(TemaDTO tema) {
		this.tema = tema;
	}
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	
}

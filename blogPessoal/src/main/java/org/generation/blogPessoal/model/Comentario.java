package org.generation.blogPessoal.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_comentario")
public class Comentario {
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JsonIgnoreProperties({"comentario","usuario"})
	private Postagem postagem;
	
	@NotNull
	@Size(max = 500)
	private String texto;
	
	@ManyToOne
	@JsonIgnoreProperties({"comentario","postagem"})
	private Usuario usuario;

	public Date getData() {
		return data;
	}

	public long getId() {
		return id;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public String getTexto() {
		return texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

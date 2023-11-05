package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

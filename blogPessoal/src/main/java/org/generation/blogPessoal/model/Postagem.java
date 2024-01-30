package org.generation.blogPessoal.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"postagem"})
	private List<Comentario> comentario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@NotNull
	@Size(max = 1000)
	private String texto;

	@NotNull
	@Size(max = 200)
	private String titulo;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	public List<Comentario> getComentario() {
		return comentario;
	}
	
	public Date getData() {
		return data;
	}
	
	public long getId() {
		return id;
	}
	
	public Tema getTema() {
		return tema;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

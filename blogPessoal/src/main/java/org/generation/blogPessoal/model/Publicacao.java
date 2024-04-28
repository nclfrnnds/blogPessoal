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
@Table(name = "tb_publicacao")
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 200)
	private String titulo;
	
	@NotNull
	@Size(max = 1000)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnoreProperties("publicacoes")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties({"publicacoes", "comentarios"})
	private Usuario usuario;
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"publicacao"})
	private List<Comentario> comentarios;

	public Publicacao() {
	}

	public Publicacao(long id, String titulo, String texto, Date data,
										Tema tema, Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.tema = tema;
		this.usuario = usuario;
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

	public Tema getTema() {
		return tema;
	}
	
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}

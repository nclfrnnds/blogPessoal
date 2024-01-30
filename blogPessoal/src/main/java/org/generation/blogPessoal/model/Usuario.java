package org.generation.blogPessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	private String foto;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String nome;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuario"})
	private List<Postagem> postagem;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String senha;
	
	private String tipo;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String usuario;
	
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
//	@JsonIgnoreProperties({"usuario", "postagem"})
//	private List<Comentario> comentario;

	public String getFoto() {
		return foto;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public String getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

//	public List<Comentario> getComentario() {
//		return comentario;
//	}
//
//	public void setComentario(List<Comentario> comentario) {
//		this.comentario = comentario;
//	}

}

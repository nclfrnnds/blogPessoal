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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String nome;

	@NotNull
	@Size(min = 1, max = 100)
	private String nomeDeUsuario;

	@NotNull
	@Size(min = 1, max = 100)
	private String senha;

	private String foto;

	private String tipo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuario"})
	private List<Publicacao> publicacao;
	
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
//	@JsonIgnoreProperties({"usuario", "publicacao"})
//	private List<Comentario> comentario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Publicacao> getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(List<Publicacao> publicacao) {
		this.publicacao = publicacao;
	}

//	public List<Comentario> getComentario() {
//		return comentario;
//	}
//
//	public void setComentario(List<Comentario> comentario) {
//		this.comentario = comentario;
//	}

}

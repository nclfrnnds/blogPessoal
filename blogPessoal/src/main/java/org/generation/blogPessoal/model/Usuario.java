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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@JsonIgnoreProperties({"usuario", "comentarios"})
	private List<Publicacao> publicacoes;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuario", "publicacao"})
	private List<Comentario> comentarios;

	public Usuario() {
	}

	public Usuario(long id,
				   String nome,
				   String nomeDeUsuario,
				   String senha,
				   String foto,
				   String tipo) {
		this.id = id;
		this.nome = nome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
	}

	public Usuario(long id,
				   String nome,
				   String nomeDeUsuario,
				   String senha,
				   String foto,
				   String tipo,
				   List<Publicacao> publicacoes,
				   List<Comentario> comentarios) {
		this.id = id;
		this.nome = nome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.publicacoes = publicacoes;
		this.comentarios = comentarios;
	}

	public Usuario (Usuario usuario) {
		this.id = usuario.id;
		this.nome = usuario.nome;
		this.nomeDeUsuario = usuario.nomeDeUsuario;
		this.senha = usuario.senha;
		this.foto = usuario.foto;
		this.tipo = usuario.tipo;
		this.publicacoes = usuario.publicacoes;
		this.comentarios = usuario.comentarios;
	}

}

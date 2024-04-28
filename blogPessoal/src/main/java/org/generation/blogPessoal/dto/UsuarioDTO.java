package org.generation.blogPessoal.dto;

import java.util.List;

public class UsuarioDTO {
	
	private long id;

	private String nome;

	private String nomeDeUsuario;

	private String senha;

	private String foto;

	private String tipo;

	private List<PublicacaoDTO> publicacoes;

	private List<ComentarioDTO> comentarios;

	public UsuarioDTO() {
	}

	public UsuarioDTO(long id, String nome, String nomeDeUsuario, String senha,
					  String foto, String tipo) {
		this.id = id;
		this.nome = nome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
	}

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

	public List<PublicacaoDTO> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<PublicacaoDTO> publicacoes) {
		this.publicacoes = publicacoes;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}

}

package org.generation.blogPessoal.model;

public class UsuarioLogin {
	
	private long id;

	private String nome;

	private String nomeDeUsuario;

	private String senha;

	private String foto;
	
	private String tipo;
	
	private String token;
	
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

	public String getFoto() {
		return foto;
	}

	public String getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}

	public String getToken() {
		return token;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

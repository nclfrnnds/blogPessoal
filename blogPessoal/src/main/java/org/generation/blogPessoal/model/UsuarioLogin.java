package org.generation.blogPessoal.model;

public class UsuarioLogin {
	
	private String foto;
	
	private long id;
	
	private String nome;
	
	private String senha;
	
	private String tipo;
	
	private String token;
	
	private String usuario;

	public String getFoto() {
		return foto;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
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

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}

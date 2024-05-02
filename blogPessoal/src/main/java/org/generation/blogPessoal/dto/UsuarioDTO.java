package org.generation.blogPessoal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private long id;

	private String nome;

	private String nomeDeUsuario;

	private String senha;

	private String foto;

	private String tipo;

	private List<PublicacaoDTO> publicacoes;

	private List<ComentarioDTO> comentarios;

	public UsuarioDTO(long id,
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

	public UsuarioDTO(long id,
					  String nome,
					  String nomeDeUsuario,
					  String senha,
					  String foto,
					  String tipo,
					  List<PublicacaoDTO> publicacoes,
					  List<ComentarioDTO> comentarios) {
		this.id = id;
		this.nome = nome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.publicacoes = publicacoes;
		this.comentarios = comentarios;
	}

}

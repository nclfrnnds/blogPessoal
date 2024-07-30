package org.generation.blogPessoal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
public class UsuarioDTO {
	
	private long id;

	private String nome;

	private String nomeDeUsuario;

	private String senha;

	private String foto;

	private String tipo;

	@JsonIgnoreProperties({"usuario", "comentarios"})
	private List<PublicacaoDTO> publicacoes;

	@JsonIgnoreProperties({"usuario", "publicacao"})
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

}

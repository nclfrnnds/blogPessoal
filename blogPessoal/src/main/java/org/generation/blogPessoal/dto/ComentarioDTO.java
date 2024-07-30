package org.generation.blogPessoal.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
public class ComentarioDTO {
	
	private long id;

	private String texto;

	private Date data = new java.sql.Date(System.currentTimeMillis());

	@JsonIgnoreProperties({ "comentarios", "publicacoes" })
	private UsuarioDTO usuario;

	@JsonIgnoreProperties({ "comentarios", "usuario" })
	private PublicacaoDTO publicacao;

}

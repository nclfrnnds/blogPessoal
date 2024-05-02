package org.generation.blogPessoal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemaDTO {
	
	private long id;
	
	private String descricao;

	private List<PublicacaoDTO> publicacoes;

	public TemaDTO(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TemaDTO(long id, String descricao, List<PublicacaoDTO> publicacoes) {
		this.id = id;
		this.descricao = descricao;
		this.publicacoes = publicacoes;
	}

}

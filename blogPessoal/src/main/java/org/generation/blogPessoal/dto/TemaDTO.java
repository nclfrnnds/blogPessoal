package org.generation.blogPessoal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
public class TemaDTO {
	
	private long id;
	
	private String descricao;

	@JsonIgnoreProperties("tema")
	private List<PublicacaoDTO> publicacoes;

	public TemaDTO(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

}

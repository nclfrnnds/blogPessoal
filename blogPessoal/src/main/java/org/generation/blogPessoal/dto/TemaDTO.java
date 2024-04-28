package org.generation.blogPessoal.dto;

import java.util.List;

public class TemaDTO {
	
	private long id;
	
	private String descricao;
	
	private List<PublicacaoDTO> publicacoes;

	public TemaDTO() {
	}

	public TemaDTO(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public TemaDTO(long id, String descricao, List<PublicacaoDTO> publicacoes) {
		this.id = id;
		this.descricao = descricao;
		this.publicacoes = publicacoes;
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PublicacaoDTO> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<PublicacaoDTO> publicacoes) {
		this.publicacoes = publicacoes;
	}

}

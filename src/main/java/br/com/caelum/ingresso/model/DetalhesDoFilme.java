package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalhesDoFilme {

	@JsonProperty("Title")
	private String titulo;

	@JsonProperty("Year")
	private String ano;
	
	@JsonProperty("Poster")
	private String imagem;
	
	@JsonProperty("Director")
	private String diretores;
	
	@JsonProperty("Writer")
	private String escritores;
	
	@JsonProperty("Actor")
	private String atores;
	
	@JsonProperty("PLot")
	private String descricao;
	
	@JsonProperty("imdbRating")
	private String avaliacao;
	
}

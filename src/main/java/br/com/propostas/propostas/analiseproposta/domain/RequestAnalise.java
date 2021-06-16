package br.com.propostas.propostas.analiseproposta.domain;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class RequestAnalise {
	
	private String documento;
	private String nome;
	private String idProposta;
	
	
	@Deprecated
	public RequestAnalise() {
	}



	public RequestAnalise(String documento, String nome, String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}



	public String getDocumento() {
		return documento;
	}



	public String getNome() {
		return nome;
	}



	public String getIdProposta() {
		return idProposta;
	}
	
	
	

}

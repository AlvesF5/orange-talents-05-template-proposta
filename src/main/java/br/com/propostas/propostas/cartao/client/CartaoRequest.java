package br.com.propostas.propostas.cartao.client;

public class CartaoRequest {
	
	private String documento;
	private String nome;
	private String idProposta;
	
	
	@Deprecated
	public CartaoRequest() {
	}


	public CartaoRequest(String documento, String nome, String idProposta) {
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

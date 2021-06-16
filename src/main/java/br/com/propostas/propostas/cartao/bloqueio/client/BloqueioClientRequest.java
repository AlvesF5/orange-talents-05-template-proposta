package br.com.propostas.propostas.cartao.bloqueio.client;

public class BloqueioClientRequest {
	
	private String sistemaResponsavel;
	
	@Deprecated
	public BloqueioClientRequest() {
	}

	public BloqueioClientRequest(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	

}

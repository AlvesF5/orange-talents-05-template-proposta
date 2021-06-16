package br.com.propostas.propostas.cartao.bloqueio.client;

public class BloqueioClientResponse {
	
	private String resultado;

	@Deprecated
	public BloqueioClientResponse() {
	}

	public BloqueioClientResponse(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}
	
}

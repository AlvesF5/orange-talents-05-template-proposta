package br.com.propostas.propostas.cartao.client;

import java.time.LocalDateTime;

import br.com.propostas.propostas.cartao.domain.Vencimento;

public class CartaoResponse {
	
	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private Double limite;
	private Vencimento vencimento;
	private String idProposta;
	
	
	
	
	public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, Double limite, Vencimento vencimento,
			String idProposta) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}


	public String getId() {
		return id;
	}


	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}


	public String getTitular() {
		return titular;
	}

	public Double getLimite() {
		return limite;
	}


	public Vencimento getVencimento() {
		return vencimento;
	}


	public String getIdProposta() {
		return idProposta;
	}
	
	
	
	

}

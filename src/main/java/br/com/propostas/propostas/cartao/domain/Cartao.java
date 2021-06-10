package br.com.propostas.propostas.cartao.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
	@Id
	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private Double limite;
	private int vencimento;
	
	
	
	
	@Deprecated
	public Cartao() {
	}



	public Cartao(String id, LocalDateTime emitidoEm, String titular, Double limite,  int vencimento) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite=limite;
		this.vencimento = vencimento;
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

	public int getVencimento() {
		return vencimento;
	}


	public Double getLimite() {
		return limite;
	}
	
	
	
	

}

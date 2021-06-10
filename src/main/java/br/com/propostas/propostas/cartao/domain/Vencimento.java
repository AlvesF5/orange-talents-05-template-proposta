package br.com.propostas.propostas.cartao.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vencimento {
	@Id
	private String id;
	private int dia;
	private LocalDateTime dataDeCriacao;
	@OneToOne
	private Cartao cartao;
	
	
	public Vencimento(String id, int dia, LocalDateTime dataDeCriacao, Cartao cartao) {
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}


	public String getId() {
		return id;
	}

	public int getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Cartao getCartao() {
		return cartao;
	}
	
	
	
	
}

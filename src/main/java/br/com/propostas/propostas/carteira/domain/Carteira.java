package br.com.propostas.propostas.carteira.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.propostas.propostas.cartao.domain.Cartao;

@Entity
public class Carteira {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
	private NomeCarteira carteira;
	
	private String email;
	
	@ManyToOne
	private Cartao cartao;
	
	
	
	@Deprecated
	public Carteira() {
	}


	public Carteira(NomeCarteira carteira, String email, Cartao cartao) {
		super();
		this.carteira = carteira;
		this.email = email;
		this.cartao = cartao;
	}





	public Long getId() {
		return id;
	}
	
	public NomeCarteira getCarteira() {
		return carteira;
	}
	
	

	public String getEmail() {
		return email;
	}


	public Cartao getCartao() {
		return cartao;
	}

	
	
	
	
	

}

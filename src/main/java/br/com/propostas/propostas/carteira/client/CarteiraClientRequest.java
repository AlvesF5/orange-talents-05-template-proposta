package br.com.propostas.propostas.carteira.client;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.propostas.propostas.carteira.domain.NomeCarteira;

public class CarteiraClientRequest {
	
	private String email;
	@Enumerated(EnumType.STRING)
	private NomeCarteira carteira;
	
	
	public CarteiraClientRequest(String email, NomeCarteira carteira) {
		this.email = email;
		this.carteira = carteira;
	}


	public String getEmail() {
		return email;
	}


	public NomeCarteira getCarteira() {
		return carteira;
	}
	
	
	

}

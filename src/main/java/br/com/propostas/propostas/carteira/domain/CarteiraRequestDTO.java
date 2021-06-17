package br.com.propostas.propostas.carteira.domain;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.propostas.propostas.cartao.domain.Cartao;

public class CarteiraRequestDTO {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private NomeCarteira carteira;
	@NotBlank @Email
	private String email;

	
	
	public Carteira transformarParaCarteira(Cartao cartao) {
			
		return new Carteira(carteira,email,cartao);
		
	}


	public NomeCarteira getCarteira() {
		return carteira;
	}
	
	public String getEmail() {
		return email;
	}



	

}

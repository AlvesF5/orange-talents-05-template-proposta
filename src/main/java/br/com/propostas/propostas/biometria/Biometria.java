package br.com.propostas.propostas.biometria;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.propostas.propostas.cartao.domain.Cartao;

@Entity
public class Biometria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String biometria;
	@ManyToOne
	private Cartao cartao;
	
	
	
	
	@Deprecated
	public Biometria() {
	}


	public Biometria(String biometria) {
		this.biometria = biometria;
	}

	
	public Long getId() {
		return id;
	}

	public String getBiometria() {
		return biometria;
	}


	public void associaCartao(Cartao cartao) {
		this.cartao = cartao;
	}


	public Cartao getCartao() {
		return cartao;
	}


	


	

	


	
	

}

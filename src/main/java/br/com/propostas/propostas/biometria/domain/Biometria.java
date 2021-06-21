package br.com.propostas.propostas.biometria.domain;

import java.time.LocalDateTime;


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
	private LocalDateTime criadaEm = LocalDateTime.now();
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


	public LocalDateTime getCriadaEm() {
		return criadaEm;
	}


	


	

	


	
	

}

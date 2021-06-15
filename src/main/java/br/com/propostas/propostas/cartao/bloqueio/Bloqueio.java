package br.com.propostas.propostas.cartao.bloqueio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.propostas.propostas.cartao.domain.Cartao;

@Entity
public class Bloqueio {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime bloqueadoEm = LocalDateTime.now();
	private String ipCliente;
	private String userAgent;
	@ManyToOne
	private Cartao cartao;
	
	
	@Deprecated
	public Bloqueio() {
	}

	public Bloqueio(String ipCliente, String userAgent) {
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getIdCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void associaCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	
	
	
	
	

}

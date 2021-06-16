package br.com.propostas.propostas.cartao.viagem;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvisoViagem {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String idCartao;
	
	private String destino;
	
	private LocalDate dataTerminoViagem;
	
	private LocalDateTime criadoEm = LocalDateTime.now();
	
	private String ipCliente;
	
	private String userAgent;
	
	
	
	@Deprecated
	public AvisoViagem() {
	}

	public AvisoViagem(String idCartao, String destino, LocalDate dataTerminoViagem, String ipCliente,
			String userAgent) {
		this.idCartao = idCartao;
		this.destino = destino;
		this.dataTerminoViagem = dataTerminoViagem;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
	}




	public Long getId() {
		return id;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTerminoViagem() {
		return dataTerminoViagem;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}
	
	
	
	
	
	

}

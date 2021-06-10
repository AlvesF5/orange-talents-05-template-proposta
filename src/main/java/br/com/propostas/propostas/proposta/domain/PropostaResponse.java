package br.com.propostas.propostas.proposta.domain;

import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PropostaResponse {
	
	private String documento;
	
	private String email;
	
	private String nome;
	
	private String endereco;
	
	private Double salario;
	@Enumerated(EnumType.STRING)
	private EstadoProposta estadoProposta;
	
	public PropostaResponse(Optional<Proposta> proposta) {
		this.documento=proposta.get().getDocumento();
		this.email=proposta.get().getEmail();
		this.nome=proposta.get().getNome();
		this.endereco=proposta.get().getEndereco();
		this.salario=proposta.get().getSalario();
		this.estadoProposta=proposta.get().getEstadoProposta();
	}
	

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public Double getSalario() {
		return salario;
	}

	public EstadoProposta getEstadoProposta() {
		return estadoProposta;
	}
	
	

}

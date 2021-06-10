package br.com.propostas.propostas.proposta.domain;



import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import br.com.propostas.propostas.cartao.domain.Cartao;

@Entity
public class Proposta {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String documento;
	
	private String email;
	
	private String nome;
	
	private String endereco;
	
	private Double salario;
	@Enumerated(EnumType.STRING)
	private EstadoProposta estadoProposta;
	
	@OneToOne
	private Cartao cartao;
	
	
	@Deprecated
	public Proposta() {
	}


	public Proposta(String documento, String email, String nome, String endereco, Double salario) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}


	public Long getId() {
		return id;
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


	public void atualizaEstadoProposta(EstadoProposta estado_proposta) {
		
		this.estadoProposta = estado_proposta;
	}


	public void associaCartao(Cartao cartao) {	
		this.cartao = cartao;
	}


			

}

package br.com.propostas.propostas.proposta.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PropostaRequestDTO {
	
	@NotBlank @CPForCNPJ
	private String documento;
	@NotBlank @Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String endereco;
	@NotNull @Positive
	private Double salario;
	
	
	
	public Proposta transformarParaProposta() {
		return new Proposta(documento,email,nome,endereco,salario);
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
	
	
	

}

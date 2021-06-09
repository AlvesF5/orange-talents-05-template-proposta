package br.com.propostas.propostas.analiseproposta;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class RespostaAnalise {
	
	
	private String documento;
	private String nome;
	@Enumerated(EnumType.STRING)
	private ResultadoSolicitacao resultadoSolicitacao;
	private String idProposta;
	
	
	public RespostaAnalise(String documento, String nome, ResultadoSolicitacao resultadoSolicitacao, String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.resultadoSolicitacao = resultadoSolicitacao;
		this.idProposta = idProposta;
	}


	

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public ResultadoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public String getIdProposta() {
		return idProposta;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((idProposta == null) ? 0 : idProposta.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((resultadoSolicitacao == null) ? 0 : resultadoSolicitacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaAnalise other = (RespostaAnalise) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (idProposta == null) {
			if (other.idProposta != null)
				return false;
		} else if (!idProposta.equals(other.idProposta))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (resultadoSolicitacao != other.resultadoSolicitacao)
			return false;
		return true;
	}



	
	
	
	
}

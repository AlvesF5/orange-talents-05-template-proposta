package br.com.propostas.propostas.analiseproposta.domain;

import br.com.propostas.propostas.proposta.domain.EstadoProposta;

public enum ResultadoSolicitacao {
	COM_RESTRICAO, SEM_RESTRICAO;
	
	public EstadoProposta retornaResultado() {
		if(this==SEM_RESTRICAO) {
			return EstadoProposta.ELEGIVEL;
		}
		return EstadoProposta.NAO_ELEGIVEL;
	}
}

package br.com.propostas.propostas.analiseproposta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.propostas.propostas.analiseproposta.domain.RequestAnalise;
import br.com.propostas.propostas.analiseproposta.domain.RespostaAnalise;



@FeignClient(name = "analiseproposta", url="${servico.analise.proposta}")
public interface AnaliseProposta {
	
	@PostMapping(value = "/api/solicitacao", produces = "application/json", consumes = "application/json")
	public RespostaAnalise respostaAnalise(RequestAnalise requestAnalise);
	
}

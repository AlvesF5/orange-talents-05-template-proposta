package br.com.propostas.propostas.analiseproposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;



@FeignClient(name = "analiseproposta", url="${servico.analise.proposta}")
public interface AnaliseProposta {
	
	@PostMapping(value = "/api/solicitacao", produces = "application/json", consumes = "application/json")
	public RespostaAnalise respostaAnalise(RequestAnalise requestAnalise);
	
}

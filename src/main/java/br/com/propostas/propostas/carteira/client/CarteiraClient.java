package br.com.propostas.propostas.carteira.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "carteira", url="${servico.recurso.cartao}")
public interface CarteiraClient {
	
	@PostMapping(value = "/api/cartoes/{id}/carteiras", produces = "application/json", consumes = "application/json")
	public CarteiraClientResponse respostaCarteria(@PathVariable("id") String id, @RequestBody CarteiraClientRequest carteiraClientRequest);

}

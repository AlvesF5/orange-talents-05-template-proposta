package br.com.propostas.propostas.cartao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "criacartao", url="${servico.recurso.cartao}")
public interface CriaCartaoClient {
	
	@PostMapping(value = "/api/cartoes", produces = "application/json", consumes = "application/json")
	public CartaoResponse cartaoResponse(CartaoRequest cartaoRequest);

}

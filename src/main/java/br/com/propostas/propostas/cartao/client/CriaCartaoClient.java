package br.com.propostas.propostas.cartao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "criacartao", url="http://localhost:8888/api")
public interface CriaCartaoClient {
	
	@PostMapping(value = "/cartoes", produces = "application/json", consumes = "application/json")
	public CartaoResponse cartaoResponse(CartaoRequest cartaoRequest);

}

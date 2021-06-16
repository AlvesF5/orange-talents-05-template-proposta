package br.com.propostas.propostas.cartao.bloqueio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "bloqueiocartao", url="${servico.recurso.cartao}")
public interface BloqueioClient {
	
	@PostMapping(value = "/api/cartoes/{id}/bloqueios", produces = "application/json", consumes = "application/json")
	public BloqueioClientResponse respostaBloqueio(@PathVariable("id") String id, @RequestBody BloqueioClientRequest bloqueioRequest);

}

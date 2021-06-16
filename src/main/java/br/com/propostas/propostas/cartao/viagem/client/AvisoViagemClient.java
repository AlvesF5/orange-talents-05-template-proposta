package br.com.propostas.propostas.cartao.viagem.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "avisoviagem", url="${servico.recurso.cartao}")
public interface AvisoViagemClient {
	
	@PostMapping(value = "/api/cartoes/{id}/avisos", produces = "application/json", consumes = "application/json")
	public AvisoViagemClientResponse respostaAvisoViagem(@PathVariable("id") String id, @RequestBody AvisoViagemClientRequest avisoViagemClientRequest);

}

package br.com.propostas.propostas.cartao.bloqueio.controller;



import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.propostas.propostas.cartao.bloqueio.client.BloqueioClient;
import br.com.propostas.propostas.cartao.bloqueio.client.BloqueioClientRequest;
import br.com.propostas.propostas.cartao.bloqueio.client.BloqueioClientResponse;
import br.com.propostas.propostas.cartao.bloqueio.domain.Bloqueio;
import br.com.propostas.propostas.cartao.bloqueio.domain.BloqueioRequest;
import br.com.propostas.propostas.cartao.bloqueio.repository.BloqueioRepository;
import br.com.propostas.propostas.cartao.domain.Cartao;
import br.com.propostas.propostas.cartao.domain.CartaoRepository;
import br.com.propostas.propostas.cartao.domain.EstadoBloqueio;
import feign.FeignException.FeignClientException;

@RestController
@RequestMapping("/bloqueios")
public class BloqueioController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private BloqueioRepository bloqueioRepository;
	
	@Autowired
	private BloqueioClient bloqueioClient;
	
		
	@PostMapping("/{idCartao}")
	public ResponseEntity<?> novoBloqueio(@PathVariable("idCartao") String idCartao, @RequestHeader(value = "User-Agent") String userAgent, UriComponentsBuilder uriBuilder){
			
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		
		Optional<Bloqueio> possivelBloqueio = bloqueioRepository.findByCartao(cartao.get());
		
		if(cartao.isPresent()) {
			if(possivelBloqueio.isPresent()) {
				 return ResponseEntity.unprocessableEntity().build();
			}
			
			String ipAddress = fetchClientIpAddr();
			BloqueioRequest bloqueioRequest = new BloqueioRequest(ipAddress, userAgent);
			Bloqueio bloqueio = bloqueioRequest.transformarParaBloqueio();
			
			BloqueioClientRequest bloqueioClientRequest = new BloqueioClientRequest("Proposta");
			BloqueioClientResponse bloqueioResponse = bloqueioClient.respostaBloqueio(cartao.get().getId(),bloqueioClientRequest);
			System.out.println(bloqueioResponse.getResultado());
			
			try {
				
				bloqueio.associaCartao(cartao.get());
				bloqueioRepository.save(bloqueio);
				cartao.get().atualizaEstadoBloqueio(EstadoBloqueio.BLOQUEADO);
				cartaoRepository.save(cartao.get());
				URI uri = uriBuilder.path("/bloqueios/{id}").buildAndExpand(bloqueio.getId()).toUri();
				return ResponseEntity.created(uri).build();
								
			} catch (FeignClientException fe) {
				fe.printStackTrace();
				return ResponseEntity.badRequest().build();
			}
			
			
			
		}
			
		
		return ResponseEntity.notFound().build();
		
		
	}
	

		
	protected String fetchClientIpAddr() {
	    HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
	    String ip = Optional.ofNullable(request.getHeader("X-FORWARDED-FOR")).orElse(request.getLocalAddr());
	    if (ip.equals("0:0:0:0:0:0:0:1")) ip = "127.0.0.1";
	    Assert.isTrue(ip.chars().filter($ -> $ == '.').count() == 3, "Illegal IP: " + ip);
	    return ip;
	}
	
	
	
	

}

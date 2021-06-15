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

import br.com.propostas.propostas.cartao.bloqueio.Bloqueio;
import br.com.propostas.propostas.cartao.bloqueio.BloqueioRepository;
import br.com.propostas.propostas.cartao.bloqueio.BloqueioRequest;
import br.com.propostas.propostas.cartao.domain.Cartao;
import br.com.propostas.propostas.cartao.domain.CartaoRepository;

@RestController
@RequestMapping("/bloqueios")
public class BloqueioController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private BloqueioRepository bloqueioRepository;
	
		
	@PostMapping("/{idCartao}")
	public ResponseEntity<?> novoBloqueio(@PathVariable("idCartao") String idCartao, @RequestHeader(value = "User-Agent") String userAgent, UriComponentsBuilder uriBuilder){
			
		String ipAddress = fetchClientIpAddr();
		
		Cartao cartao = cartaoRepository.findById(idCartao);
		
		Optional<Bloqueio> possivelBloqueio = bloqueioRepository.findByCartao(cartao);
		
		if(cartao!=null) {
			if(possivelBloqueio.isPresent()) {
				 return ResponseEntity.unprocessableEntity().build();
			}
			
			BloqueioRequest bloqueioRequest = new BloqueioRequest(ipAddress, userAgent);
			Bloqueio bloqueio = bloqueioRequest.transformarParaBloqueio();
			bloqueio.associaCartao(cartao);
			bloqueioRepository.save(bloqueio);
			URI uri = uriBuilder.path("/bloqueios/{id}").buildAndExpand(bloqueio.getId()).toUri();
			return ResponseEntity.created(uri).build();
			
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

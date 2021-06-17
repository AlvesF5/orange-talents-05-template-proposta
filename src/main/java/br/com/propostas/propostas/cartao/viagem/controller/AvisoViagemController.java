package br.com.propostas.propostas.cartao.viagem.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.propostas.propostas.cartao.domain.Cartao;
import br.com.propostas.propostas.cartao.domain.CartaoRepository;
import br.com.propostas.propostas.cartao.viagem.AvisoViagem;
import br.com.propostas.propostas.cartao.viagem.AvisoViagemRequest;
import br.com.propostas.propostas.cartao.viagem.client.AvisoViagemClient;
import br.com.propostas.propostas.cartao.viagem.client.AvisoViagemClientRequest;

import br.com.propostas.propostas.cartao.viagem.repository.AvisoViagemRepository;
import feign.FeignException;


@RestController
@RequestMapping("/avisoviagens")
public class AvisoViagemController {
	
	@Autowired
	private AvisoViagemRepository avisoViagemRepository;
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private AvisoViagemClient avisoViagemClient;
	
	@PostMapping("/{idCartao}")
	public ResponseEntity<?> novoAvisoViagem(@PathVariable("idCartao") String idCartao, @RequestHeader(value = "User-Agent") String userAgent, 
			@RequestBody @Valid AvisoViagemRequest avisoViagemRequest){
		
		String ipClient = fetchClientIpAddr();
		
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		
		if(cartao.isPresent()) {
			AvisoViagem avisoViagem = avisoViagemRequest.transformarParaAvisoViagem(idCartao, ipClient, userAgent);
					
			try {
				avisoViagemClient.respostaAvisoViagem(cartao.get().getId(), new AvisoViagemClientRequest(avisoViagem.getDestino(), avisoViagem.getDataTerminoViagem()));
				avisoViagemRepository.save(avisoViagem);
				return ResponseEntity.ok().build();
			} catch (FeignException fe) {
				fe.printStackTrace();
				return ResponseEntity.unprocessableEntity().body("Erro ao salvar aviso");
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

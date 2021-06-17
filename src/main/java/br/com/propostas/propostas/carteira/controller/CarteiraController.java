package br.com.propostas.propostas.carteira.controller;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.propostas.propostas.cartao.domain.Cartao;
import br.com.propostas.propostas.cartao.domain.CartaoRepository;
import br.com.propostas.propostas.carteira.client.CarteiraClient;
import br.com.propostas.propostas.carteira.client.CarteiraClientRequest;
import br.com.propostas.propostas.carteira.domain.Carteira;
import br.com.propostas.propostas.carteira.domain.CarteiraRequestDTO;
import br.com.propostas.propostas.carteira.repository.CarteiraRepository;
import feign.FeignException;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {
	
	@Autowired
	private CarteiraClient carteiraClient;
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	@Autowired
	private CartaoRepository cartaoRepository;

	
	@PostMapping("/{idCartao}")
	public ResponseEntity<?> novaCarteira(@PathVariable("idCartao") String idCartao, @RequestBody @Valid CarteiraRequestDTO carteiraRequestDTO, UriComponentsBuilder uriBuilder){
		
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		
		if(cartao.isPresent()) {
			
			try {
				Carteira carteira = carteiraRequestDTO.transformarParaCarteira(cartao.get());
				carteiraClient.respostaCarteria(cartao.get().getId(), new CarteiraClientRequest(carteira.getEmail(), carteira.getCarteira()));
				carteiraRepository.save(carteira);
				URI uri = uriBuilder.path("/carteiras/{id}").buildAndExpand(carteira.getId()).toUri();
				return ResponseEntity.created(uri).build();
			} catch (FeignException fe) {
				fe.printStackTrace();
				return ResponseEntity.unprocessableEntity().body("Erro ao tentar associar cartão a carteira");
			}
			
					
		}
		
		return ResponseEntity.notFound().build();
		
	}

}

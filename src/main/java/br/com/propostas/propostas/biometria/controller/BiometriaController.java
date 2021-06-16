package br.com.propostas.propostas.biometria.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.propostas.propostas.biometria.Biometria;
import br.com.propostas.propostas.biometria.BiometriaRequest;
import br.com.propostas.propostas.biometria.repository.BiometriaRepository;
import br.com.propostas.propostas.cartao.domain.Cartao;
import br.com.propostas.propostas.cartao.domain.CartaoRepository;

@RestController
@RequestMapping("/biometrias")
public class BiometriaController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private BiometriaRepository biometriaRepository;
	
	@PostMapping("/{idCartao}")
	public ResponseEntity<?> novaBiometria(@PathVariable("idCartao") String idCartao, @RequestBody @Valid BiometriaRequest biometriaRequest, UriComponentsBuilder uriBuilder){
		
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		
		Biometria biometria = biometriaRequest.transformarParaBiometria();
		
	 
		if(cartao.isPresent()) {
			biometria.associaCartao(cartao.get());
			biometriaRepository.save(biometria);
			URI uri = uriBuilder.path("/biometrias/{id}").buildAndExpand(biometria.getId()).toUri();
			cartao.get().adicionaBiometria(Arrays.asList(biometria));	
			return ResponseEntity.created(uri).build();
			
		
		} 
		
		return ResponseEntity.notFound().build();
			
			
		
	}

}

package br.com.propostas.propostas.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;


import br.com.propostas.propostas.proposta.domain.Proposta;
import br.com.propostas.propostas.proposta.domain.PropostaRequestDTO;
import br.com.propostas.propostas.repository.PropostaRepository;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@PostMapping
	public ResponseEntity<?> novaProposta(@RequestBody @Valid PropostaRequestDTO propostaDTO, UriComponentsBuilder uriBuilder){
		
		Proposta possivelProposta = propostaRepository.findByDocumento(propostaDTO.getDocumento());
		
		if(possivelProposta==null) {
			Proposta proposta = propostaDTO.transformarParaProposta();
		    propostaRepository.save(proposta);
		    
		    URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
			
			return ResponseEntity.created(uri).build();
		}else 
			return ResponseEntity.unprocessableEntity().build();
		
	}

}

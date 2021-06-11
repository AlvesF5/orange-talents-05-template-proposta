package br.com.propostas.propostas.controller;

import java.net.URI;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import br.com.propostas.propostas.analiseproposta.AnaliseProposta;
import br.com.propostas.propostas.analiseproposta.RequestAnalise;
import br.com.propostas.propostas.analiseproposta.RespostaAnalise;
import br.com.propostas.propostas.proposta.domain.EstadoProposta;
import br.com.propostas.propostas.proposta.domain.Proposta;
import br.com.propostas.propostas.proposta.domain.PropostaRequestDTO;
import br.com.propostas.propostas.proposta.domain.PropostaResponse;
import br.com.propostas.propostas.repository.PropostaRepository;
import feign.FeignException;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private AnaliseProposta analiseProposta;
	
	
	
	private RespostaAnalise respostaAnalise;
	private RequestAnalise requestAnalise;
	
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@PostMapping
	public ResponseEntity<?> novaProposta(@RequestBody @Valid PropostaRequestDTO propostaDTO, UriComponentsBuilder uriBuilder){
		
		Proposta possivelProposta = propostaRepository.findByDocumento(propostaDTO.getDocumento());
		
		
		if(possivelProposta==null) {
			
			Proposta proposta = propostaDTO.transformarParaProposta();
		    propostaRepository.save(proposta);
		    URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
		    	
			try {
				 
			    requestAnalise = new RequestAnalise(proposta.getDocumento(), proposta.getNome(), proposta.getId().toString());
			    
			    respostaAnalise = analiseProposta.respostaAnalise(requestAnalise);
			    	    
			    proposta.atualizaEstadoProposta(respostaAnalise.getResultadoSolicitacao().retornaResultado());
			    
			    propostaRepository.save(proposta);
			    		
				
			} catch (FeignException.UnprocessableEntity e) {
				proposta.atualizaEstadoProposta(EstadoProposta.NAO_ELEGIVEL);
				propostaRepository.save(proposta);
				System.out.println(e.getMessage());
			}
			
			return ResponseEntity.created(uri).build();
			
			
		}
		
			return ResponseEntity.unprocessableEntity().build();
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PropostaResponse> buscarProposta(@PathVariable("id") Long id){
		Optional<Proposta> proposta = propostaRepository.findById(id);
		
		if(proposta.isPresent()) {
			return ResponseEntity.ok(new PropostaResponse(proposta));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	


}

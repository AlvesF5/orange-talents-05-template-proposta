package br.com.propostas.propostas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.propostas.propostas.cartao.client.CartaoRequest;
import br.com.propostas.propostas.cartao.client.CartaoResponse;
import br.com.propostas.propostas.cartao.client.CriaCartaoClient;
import br.com.propostas.propostas.cartao.domain.Cartao;
import br.com.propostas.propostas.cartao.domain.CartaoRepository;
import br.com.propostas.propostas.proposta.domain.EstadoProposta;
import br.com.propostas.propostas.proposta.domain.Proposta;
import br.com.propostas.propostas.repository.PropostaRepository;

@Component
@ConditionalOnProperty(value="scheduling.enabled", matchIfMissing = true)
public class PropostaScheduled {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private CriaCartaoClient criarCartao;
	@Autowired
	private PropostaRepository propostaRepository;	

	@Autowired
	private CartaoRepository cartaoRepository;
	
	
	@Scheduled(fixedDelay = 10000)
	public void associaCartoes() {
	
		List<Proposta> propostas = propostaRepository.findByEstadoPropostaAndCartaoIsNull(EstadoProposta.ELEGIVEL);
		
		propostas.forEach(
				proposta -> {
								
					CartaoRequest  cartaoRequest = new CartaoRequest(proposta.getDocumento(), proposta.getNome(), proposta.getId().toString());
					CartaoResponse cartaoResponse = criarCartao.cartaoResponse(cartaoRequest);
					
					Cartao cartao = new Cartao(cartaoResponse.getId().toString(),cartaoResponse.getEmitidoEm(),cartaoResponse.getTitular(),cartaoResponse.getLimite(),cartaoResponse.getVencimento().getDia());
					
					cartaoRepository.save(cartao);
					
					proposta.associaCartao(cartao);
					
					propostaRepository.save(proposta);
				}
				);
		
		
		
	}

}

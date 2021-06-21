package br.com.propostas.propostas.proposta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propostas.propostas.proposta.domain.EstadoProposta;
import br.com.propostas.propostas.proposta.domain.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	
	Proposta findByDocumento(String documento);
	
	List<Proposta> findByEstadoPropostaAndCartaoIsNull(EstadoProposta estadoProposta);
	
}

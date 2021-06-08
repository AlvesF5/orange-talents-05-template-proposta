package br.com.propostas.propostas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propostas.propostas.proposta.domain.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	
	Proposta findByDocumento(String documento);
	
}

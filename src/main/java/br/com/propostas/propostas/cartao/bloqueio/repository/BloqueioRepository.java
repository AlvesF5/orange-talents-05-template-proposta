package br.com.propostas.propostas.cartao.bloqueio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propostas.propostas.cartao.bloqueio.domain.Bloqueio;
import br.com.propostas.propostas.cartao.domain.Cartao;

public interface BloqueioRepository extends JpaRepository<Bloqueio, Long> {
	
	Optional<Bloqueio> findByCartao(Cartao cartao);
	
}

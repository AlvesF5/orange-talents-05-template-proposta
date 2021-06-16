package br.com.propostas.propostas.cartao.domain;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	Optional<Cartao> findById(String id);
}

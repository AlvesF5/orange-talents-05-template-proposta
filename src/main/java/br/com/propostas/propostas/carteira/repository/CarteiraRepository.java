package br.com.propostas.propostas.carteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propostas.propostas.carteira.domain.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}

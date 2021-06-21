package br.com.propostas.propostas.biometria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propostas.propostas.biometria.domain.Biometria;

public interface BiometriaRepository extends JpaRepository<Biometria, Long> {

}

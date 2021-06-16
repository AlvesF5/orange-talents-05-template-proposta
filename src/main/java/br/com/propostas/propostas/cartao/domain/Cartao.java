package br.com.propostas.propostas.cartao.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.propostas.propostas.biometria.Biometria;

@Entity
public class Cartao {
	@Id
	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private Double limite;
	private int vencimento;
	@OneToMany(mappedBy="cartao")
	private List<Biometria> biometria;
	@Enumerated(EnumType.STRING)
	private EstadoBloqueio estadoBloqueio = EstadoBloqueio.NAO_BLOQUEADO;
	

	@Deprecated
	public Cartao() {
	}

	public Cartao(String id, LocalDateTime emitidoEm, String titular, Double limite,  int vencimento) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite=limite;
		this.vencimento = vencimento;
	}

	
	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public int getVencimento() {
		return vencimento;
	}


	public Double getLimite() {
		return limite;
	}



	public List<Biometria> getBiometria() {
		return biometria;
	}
	
	public EstadoBloqueio getEstadoBloqueio() {
		return estadoBloqueio;
	}

	public void adicionaBiometria(List<Biometria> biometria) {
		this.biometria = biometria;
	}
	
	public void atualizaEstadoBloqueio(EstadoBloqueio estadoBloqueio) {
		this.estadoBloqueio = estadoBloqueio;
	}

	
	
	

}

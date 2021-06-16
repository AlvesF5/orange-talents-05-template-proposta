package br.com.propostas.propostas.cartao.viagem;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;




public class AvisoViagemRequest {
	
	@NotBlank
	private String destino;
	
	@Future @NotNull @JsonFormat(pattern="dd/MM/yy", shape = Shape.STRING)
	private LocalDate dataTerminoViagem;
	

	public AvisoViagem transformarParaAvisoViagem(String idCartao, String ipCliente, String userAgent) {	
		return new AvisoViagem(idCartao,destino,dataTerminoViagem,ipCliente,userAgent);
	}


	public String getDestino() {
		return destino;
	}


	public LocalDate getDataTerminoViagem() {
		return dataTerminoViagem;
	}



	
	
	

}

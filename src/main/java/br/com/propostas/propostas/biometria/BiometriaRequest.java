package br.com.propostas.propostas.biometria;



import javax.validation.constraints.NotBlank;


import br.com.propostas.propostas.biometria.validation.IsBase64;


@IsBase64
public class BiometriaRequest {
    
	@NotBlank
	private String biometria;

	
	
	public Biometria transformarParaBiometria() {
		return new Biometria(biometria);
	}


	public String getBiometria() {
		return biometria;
	}

	
	
	
}

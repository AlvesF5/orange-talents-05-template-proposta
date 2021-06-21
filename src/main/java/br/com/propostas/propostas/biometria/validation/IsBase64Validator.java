package br.com.propostas.propostas.biometria.validation;






import java.util.Base64;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.propostas.propostas.biometria.domain.BiometriaRequest;






public class IsBase64Validator implements ConstraintValidator<IsBase64, BiometriaRequest> {
	
	
	@Override
	public boolean isValid(BiometriaRequest biometria, ConstraintValidatorContext context) {
		
		try {
			 Base64.getDecoder().decode(biometria.getBiometria());
			 return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}


}

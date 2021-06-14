package br.com.propostas.propostas.biometria.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = IsBase64Validator.class)
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsBase64 {
	
	String message() default "Formato da Biometria é invalido!";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
	
}

package br.com.propostas.propostas.proposta.domain;



import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;





public class TextCrypt {
	

	public String queryableText(String texto) {

	  @SuppressWarnings("deprecation")
	  TextEncryptor encryptor =  Encryptors.queryableText("@D3v21.*",
	      "5c0744940b5c369b");
	  
	  return encryptor.encrypt(texto);

	}

}

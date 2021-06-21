import org.jasypt.util.text.TextEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;

public class TesteCrypt {

	private static TextEncryptor encryptor = (TextEncryptor) Encryptors.text("@D3v21.", "salt");

			
	public String encrypt(String message) {
		
		return encryptor.encrypt(message).toString();
		
	}
	
	public String decrypt(String encryptedMessage) {

		return encryptor.decrypt(encryptedMessage);
		
	}
		
			

}

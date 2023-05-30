
public class HMEProtocol {

	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	String encryptedString = "";
	
	public String CeasarCipher(String input, int shift) {
		for(int i = 0; i < input.length(); i++) {
			if( input != "") {
				int originalPosition = alphabet.indexOf(input.charAt(i));
				int newPosition = (shift + originalPosition ) % 26;
				char newCharacter = alphabet.charAt(newPosition);
				
				encryptedString +=newCharacter;			
				
			}
		}
		
		return encryptedString;
	}
}

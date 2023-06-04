
import java.util.Random;
import org.json.*;
import com.google.gson.Gson; 

public class HMEProtocol {

	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static String encryptedString = "";
	
	
	public static String CeasarCipher(String message, int shift) {
		String convertedToString = String.valueOf(message);  
		convertedToString = convertedToString.replace("[", "");
		convertedToString  = convertedToString.replace("\"", "");
		convertedToString  = convertedToString.replace("]", "");
		
		for(int i = 0; i < convertedToString.length(); i++) {
			if( message != "") {
				int originalPosition = alphabet.indexOf((convertedToString).charAt(i));
				int newPosition = (shift + originalPosition ) % 26;
				char newCharacter = alphabet.charAt(newPosition);
				
				encryptedString +=newCharacter;			
				
			}
		}
		
		return encryptedString;
	}
	
	
	public static JSONObject buildResponse(String jsonRequest){
		JSONObject json = new JSONObject();
		Random rn = new Random();
	
		
		jsonRequest= jsonRequest.replace("[[", "");
		jsonRequest  = jsonRequest.replace("\"", "");
		jsonRequest  = jsonRequest.replace("]]", "");
		
		JSONObject sentJson = new JSONObject(jsonRequest);
		Object message = sentJson.get("message");
		
		json.append("message ID", rn.nextInt());
		json.append("sender email", sentJson.get("sender email"));
		json.append("receiver email", sentJson.get("receiver email"));
		json.append("subject", sentJson.get("subject"));
		String shift = sentJson.get("shift").toString(); 
		shift = shift.replace("[", "");
		shift = shift.replace("]", "");
		
		json.append("message", CeasarCipher(message.toString(), Integer.parseInt(shift)));
		
		return json;
		
		

	}
}

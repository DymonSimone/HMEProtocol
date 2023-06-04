import java.io.*;  
import java.net.*;
import java.util.Scanner;

import org.json.JSONObject;  
import com.google.gson.Gson; 

public class Server {

	//Declares a port to listen on
	static int PORT = 3000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//setup server to listen on port 3000
		ServerSocket socket;
		try {
			socket = new ServerSocket(PORT);
			Socket connection = socket.accept();
			
			//Invoke system writer and reader
			 PrintWriter out =
				        new PrintWriter(connection.getOutputStream());
			 
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 
			 //read input
			 String stri = in.readLine();
			 System.out.println(stri);
			 
			 //HME protocol
			 HMEProtocol hme = new HMEProtocol();
			 System.out.println(stri);
			 
			 
			 
			 //build response
			 JSONObject result = hme.buildResponse(stri);
			 
			 //prints the encrypted message
			 System.out.print("The encrypted message being sent is:");  
			 System.out.println(result.get("message"));  
			 socket.close();  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	


}

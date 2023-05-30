import java.io.*;  
import java.net.*;

public class Client {

	public static void main(String[] args) {  
     
		try {
			Socket serverConnection =new Socket("localhost",3000);
			 PrintWriter out =
				        new PrintWriter(serverConnection.getOutputStream());
			 
			 HMEProtocol hme = new HMEProtocol();
			 
			 String result = hme.CeasarCipher("dymon", 1);
			 
			 out.write(result);
			 
			 out.flush();
			 out.close();
			 serverConnection.close();
			 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		


	}
	
}
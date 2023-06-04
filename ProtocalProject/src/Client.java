import java.io.*;  
import java.net.*;
import org.json.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {  
     
		//Declares a port to listen on
		int PORT = 3000;
		
		try {
			
			//Gets a host from user 
			System.out.println("Specify a server to connet to 'localhost' or your IP:");
			Scanner scanner = new Scanner(System.in);
			
			// establish connection to server
			Socket serverConnection =new Socket(scanner.next(),PORT);
			
			// setup system writer
			 PrintWriter out =
				        new PrintWriter(serverConnection.getOutputStream());
			 
			 // send request to server
			 out.write(buildRequest().toString());
			 
			 //close connection
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
	
	// build a request
	public static JSONObject buildRequest(){
		JSONObject json = new JSONObject();
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Enter sender email address:");
		json.append("sender email", scanner.nextLine());
		System.out.println("Enter receiver email address:");
		json.append("receiver email", scanner.nextLine());
		System.out.println("Enter an optional subject:");
		json.append("subject",  scanner.nextLine());
		System.out.println("Enter message:");
		json.append("message", scanner.nextLine());
		System.out.println("Enter shift amount:");
		json.append("shift", scanner.nextLine());
		return json;
		
		

	}
	
}


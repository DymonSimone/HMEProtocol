import java.io.*;  
import java.net.*;  

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket socket;
		try {
			socket = new ServerSocket(3000);
			Socket connection = socket.accept();
			
			 PrintWriter out =
				        new PrintWriter(connection.getOutputStream());
			 
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 
			 String stri = in.readLine();
			 
			 
			 System.out.println("message:= "+stri);  
			 socket.close();  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}

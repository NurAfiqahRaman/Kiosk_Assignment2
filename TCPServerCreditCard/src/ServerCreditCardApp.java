import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerCreditCardApp {
public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerCreditCardFrame serverFrame = new ServerCreditCardFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
			int portNo = 1123;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			CreditCardAuthorization cc=new CreditCardAuthorization();
			
			// Counter to keep track the number of requested connection
			int totalRequest = 0;
			
			// Server needs to be alive forever
			while (true) {
				
				// Message to indicate server is alive
				serverFrame.updateServerStatus(false);
				
				
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				CreditCardAuthorization c=new CreditCardAuthorization();
				
				Scanner sc=new Scanner(System.in);
				System.out.print("Card Number= ");
				int creditCardNumber=sc.nextInt();
				String message=cc.statusCard(creditCardNumber);
				
				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());
				
				// Send current date back to the client
				outputStream.writeUTF(message);
				
				// Close the socket
				clientSocket.close();
				
			}
}	
				
				
				
				
		

}

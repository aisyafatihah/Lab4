import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

	public class ServerTranslatingApplication {

		
		public static void main(String[] args) throws Exception {
			
			ServerSocket serverSocket = null;
			
			try {
				
				int portNo = 1996;
				serverSocket = new ServerSocket(portNo);
				
				System.out.println("\n\n\t----------------------------------------------");
				System.out.println("\t\t       Server      ");
				System.out.println("\t\tWaiting for request...");
				System.out.println("\t----------------------------------------------");
					
				
				while(true) {
				
					Socket socket1 = serverSocket.accept();
					
					//Read data from client
					DataInputStream dataInputStream = new DataInputStream(socket1.getInputStream());
					
					Translator translator = new Translator();
					
					translator.setText(dataInputStream.readUTF()); 
					 String text = translator.getText();
					 
					 
					Translator translator1 = new Translator(text);
		
					DataOutputStream dataOutputStream = new DataOutputStream(socket1.getOutputStream());
					
					//Send data to client
					dataOutputStream.writeUTF(translator1.getTranslatedText());
					dataOutputStream.flush();
									
					//Close stream
					socket1.close();
					dataInputStream.close();
					dataOutputStream.close();
				
				}
				
				
			}catch(IOException ex) {
				
				if(serverSocket != null)
					serverSocket.close();
				
				ex.printStackTrace();
				
			}

		}

	}
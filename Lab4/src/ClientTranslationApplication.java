import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientTranslationApplication {

	public static void main(String[] args) {
					
		try {
			
			Socket socket = new Socket(InetAddress.getLocalHost(),1996);
			
			Scanner sc = new Scanner(System.in);
			
			//Send data to server
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("\n\t----------------------------------------------");
			System.out.println("\t\t       Client ");
			System.out.println("\t----------------------------------------------");
			
			//take input text
			System.out.print("\tEnter text:  ");
			String text =(sc.nextLine());
			
			//send the text to server
			dataOutputStream.writeUTF(text);
			dataOutputStream.flush();
		
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			
			//assign object to read data from server
			String newText = dataInputStream.readUTF();
		
			System.out.println("\n\tTranslation " );
			System.out.print("\t----------------------------------------------");
			System.out.println("\n\tEnglish               Arabic         Korean");
			System.out.println("\t----------------------------------------------");
			System.out.println("\t" + newText);
 			
			//Close everything
			dataOutputStream.close();
			socket.close();
			dataInputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
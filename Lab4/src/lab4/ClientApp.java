package lab4;

	import java.io.IOException;
	import java.io.PrintStream;
	import java.net.Socket;
	import java.net.UnknownHostException;
	import java.util.Scanner;
	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	
	import java.net.InetAddress;
	
	public class ClientApp {

		public static void main(String args[]) throws UnknownHostException, IOException
		{
			//Define variable to input text
			String text;
			
			Scanner sc= new Scanner(System.in);
			
			Socket socket = new Socket("127.0.0.1",1234);
			
			//Send data to server
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Enter text: ");
			text=sc.nextLine();
			
			//Send text to server
			outputStream.writeUTF(text);
			outputStream.flush();
			
			//Read from server
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			int sentence = dataIn.readInt();
			
						
			//Print words
			System.out.print("Number of words in the sentence: ");
			System.out.println(sentence);
		}
	}
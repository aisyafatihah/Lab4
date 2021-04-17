package lab4;

	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	
	public class ServerApp {
		//private static final String String = null;

		public static void main(String args[]) throws IOException
		{
			String words;
			int count=0, portNo=1234;
			
			ServerSocket serverSocket=new ServerSocket(portNo);
			Socket soket=serverSocket.accept();
			
			//Read input from client
			DataInputStream dataIn = new DataInputStream(soket.getInputStream());
			words=dataIn.readUTF();
			
			//Count word in sentence using method
			count=NumberOfWords(words); 
			
			//Send data back to client
			DataOutputStream dataOut = new DataOutputStream(soket.getOutputStream());
			dataOut.writeInt(count);
			dataOut.flush();
			
			//Close everything
			soket.close();
			dataIn.close();
			dataOut.close();
			serverSocket.close();			
			}	


	public static int NumberOfWords(String words)
	{

	    if(words.isBlank()) 
	    {
	        return 0;
	    }
	    
	    int count = 0;
	    
	    for(int index = 0;index<words.length() -1 ;index++) 
	    {
	        if(words.charAt(index) == ' ' && words.charAt(index +1) != ' ')
	        {
	            count += 1;
	        }
	    }
	    return count + 1;
	}
}
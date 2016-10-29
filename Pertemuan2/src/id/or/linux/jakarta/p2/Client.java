package id.or.linux.jakarta.p2;

import java.io.*;
import java.net.*;
public class Client{
	Socket requestSocket;
	DataOutputStream out;
 	ObjectInputStream in;
 	String message;
	void run()
	{
		try{
			//1. creating a socket to connect to the server
			requestSocket = new Socket("localhost", 7801);
			System.out.println("Connected to localhost in port 7801");
			//2. get Input and Output streams
			out = new DataOutputStream(requestSocket.getOutputStream());
			System.out.println("flush output stream");
			//out.flush();
			try{
				in = new ObjectInputStream(requestSocket.getInputStream());
			}catch(Exception e){
				e.printStackTrace();
			}
			//3: Communicating with the server
			System.out.println("Entering Communication to Server");
			do{
				try{
					//message = (String)in.readObject();
					System.out.println("server>" + message);
					sendMessage("Hi my server");
					message = "How are U ..";
					sendMessage(message);
				}
				catch(Exception classNot){
					System.err.println("data received in unknown format");
				}
			}while(!message.equals("bye"));
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg)
	{
		try{
			out.write(msg.getBytes());;
			out.flush();
			System.out.println("client>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		Client client = new Client();
		client.run();
	}
}


package id.or.linux.jakarta.p2;

import java.io.*;
import java.net.*;
public class Server{
	ServerSocket providerSocket;
	Socket connection = null;
	PrintStream out;
	DataInputStream in;
	String message;
	void run()
	{
		try{
			//1. creating a server socket
			providerSocket = new ServerSocket(7801);
			//2. Wait for connection
			System.out.println("Waiting for connection");
			connection = providerSocket.accept();
			System.out.println("Connection received from " + connection.getInetAddress().getHostName());
			//3. get Input and Output streams
			out = new PrintStream(connection.getOutputStream());
			out.flush();
			in = new DataInputStream(connection.getInputStream());
			//sendMessage("Connection successful ");
			//4. The two parts communicate via the input and output streams
			do{
				try{
					System.out.println("Iteration");
					message = in.readLine();
					System.out.println("client>" + message);
					sendMessage("Connection successful "+message);
					System.out.println("Well it's success");
					if (message.equals("bye"))
						sendMessage("bye");
				}catch(Exception classnot){
					classnot.printStackTrace();
					System.err.println("Data received in unknown format");
				}
			}while(!message.equals("bye"));
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg)
	{
		try{
			out.println(msg);
			out.flush();
			System.out.println("server>" + msg);
		}
		catch(Exception ioException){
			ioException.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		Server server = new Server();
		while(true){
			server.run();
		}
	}
}


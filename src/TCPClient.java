import java.io.*;
import java.net.*;

public class TCPClient implements Runnable {
	String serverIP;
	int    myPort;
	
	public TCPClient (String serverIP, int myPort) {
		this.serverIP = serverIP;
		this.myPort = myPort;
	}
	
	public void receive()  throws UnknownHostException, IOException{
		Socket sock = new Socket(serverIP, myPort);
		System.out.println("Conexão estabelecida.");
		
		boolean running = true;
		while(running) {
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println("DICK: " + inputStream.readLine());
		}
		sock.close();
	}
	
	public void run() {
		try {
			receive();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

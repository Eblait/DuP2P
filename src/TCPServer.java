import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer implements Runnable {
	Socket sock;

	public TCPServer (Socket sock) {
		this.sock = sock;
	}
	
	public void send() throws UnknownHostException, IOException {
		String outToClient;
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		
		System.out.println("Conexão estabelecida. Pode digitar:");
		
		boolean running = true;
		while(running) {
			outToClient = scanner.next();
			DataOutputStream outputStream = new DataOutputStream(sock.getOutputStream());
			outputStream.writeBytes(outToClient);
		}
		sock.close();
	}
	
	public void run() {
		try {
			send();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPHandler implements Runnable {

	private int welcomePort;
	private ServerSocket welcomeSocket;
	private String IP, lastIP;

	public TCPHandler(int welcomePort) throws IOException {
		IP = "";
		lastIP = "";
		this.welcomePort = welcomePort;
		welcomeSocket = new ServerSocket(welcomePort);

	}
	
	public void setIP (String IP) {
		this.IP = IP;
	}

	@Override
	public void run() {
		try {
			startLocalServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startLocalServer() throws IOException {		
		while (true) {
			Socket sock = this.welcomeSocket.accept();
			Thread t1 = new Thread (new TCPServer (sock));			

			IP = sock.getInetAddress().toString().substring(1);

			if (IP.equals(lastIP)) {
				System.out.println("interrupted");
				t1.interrupt();
			} else {
				t1.start();
				System.out.println("not interrupted");
				Thread t2 = new Thread (new TCPClient(IP, welcomePort));

				lastIP = IP;
				t2.start();
			}
		}		

	}

}

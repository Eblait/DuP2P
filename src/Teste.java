import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Teste {
	public static void main(String[] args) {

		TCPHandler handler = null;
		try {
			handler = new TCPHandler(2000);
			Thread handlerThread = new Thread (handler);
			handlerThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Thread t2 = new Thread (new TCPClient("G1C20", 2000));
		Thread t3 = new Thread (new TCPClient("G1C21", 2000));
		
		t2.start();
		t3.start();
	}
}

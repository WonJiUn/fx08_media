package socket;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReceiver extends Thread{
	private Socket sock;
	ClientReceiver(Socket sock){ this.sock = sock; }
	public void run() {
		InputStream in;
		String readData;
		try {
			in = sock.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			while(true) {
				readData = dis.readUTF();
				System.out.println(readData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

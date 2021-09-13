package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner input = new Scanner(System.in);
		Socket sock = new Socket("210.221.253.215",12345);//접속할 서버의 ip/port
		OutputStream out = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		
		String readData;
		
		ClientReceiver rcv = new ClientReceiver(sock);
		rcv.start();

		while(true) {
			//System.out.print("송신 문자열 입력 : ");
			String data = input.next();
			dos.writeUTF(data);
		}
		//dos.close();
		//out.close();
		//sock.close();
	}
}


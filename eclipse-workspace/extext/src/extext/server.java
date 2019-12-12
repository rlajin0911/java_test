package extext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public server() {
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9998);
			System.out.println("start");
			socket = listener.accept();
			if (listener != null) {
				listener.close();
				System.out.println("listener close");
			}
			if (socket != null) {
				socket.close();
				System.out.println("socket close");
			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		new server();
	}
}

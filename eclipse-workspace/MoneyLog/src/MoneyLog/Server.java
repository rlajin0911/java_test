package MoneyLog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999); // ���� ���� ����
			System.out.println("������ ��ٸ��� �ֽ��ϴ�.....");
			socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���
			System.out.println("����Ǿ����ϴ�.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ���");
					break; // "bye"�� ������ ���� ����
				}
				System.out.println(inputMessage); // ���� �޽����� ȭ�鿡 ���
				out.write("server"); // ��� ��� ���ڿ� ����
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (socket != null)
					socket.close(); // ��ſ� ���� �ݱ�
				if (listener != null)
					listener.close(); // ���� ���� �ݱ�
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}

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
			listener = new ServerSocket(9999); // 서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다.....");
			socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 연결을 종료하였음");
					break; // "bye"를 받으면 연결 종료
				}
				System.out.println(inputMessage); // 받은 메시지를 화면에 출력
				out.write("server"); // 계산 결과 문자열 전송
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (socket != null)
					socket.close(); // 통신용 소켓 닫기
				if (listener != null)
					listener.close(); // 서버 소켓 닫기
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}

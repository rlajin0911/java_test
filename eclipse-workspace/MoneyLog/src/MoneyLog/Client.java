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
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Client {
	Scanner sc = new Scanner(System.in);
	ArrayList<MoneyLog> ml = new ArrayList<MoneyLog>(10);
	ArrayList<Member> m = new ArrayList<Member>(10);
	FileInputStream fis = null;
	FileOutputStream fos = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	private Socket socket = null;

	public Client() {
		try {
			menu();
		} catch (Exception e) {
			System.out.println("Client connerting error");
		}
	}

	public int scan() {
		try {
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println("다시 입력하세요.");
			return -1;
		}
	}

	public void menu() throws IOException {
		int a = -1;
		while (a != 7) {
			System.out.println(
					"0.서버 연결 및 로그인 1.가계부 데이터 입력 2.가계부 리스트 보기3.신규 회원정보 입력 4.회원리스트보기 5.회원정보수정 6.회원정보삭제 7.종료(파일저장)");
			a = scan();
			if (a == 0) {
				login();
			} else if (a == 1) {
				inputData();
			} else if (a == 2) {
				showData();
			} else if (a == 3) {
				inputMember();
			} else if (a == 4) {
				showMember();
			} else if (a == 5) {
				updateMember();
			} else if (a == 6) {
				deleteMember();
			}
		}
		fileSave();
		System.out.println("파일에 저장 되었습니다.");
		System.out.println("종료되었습니다.");
		out.write("bye");
		out.flush();
	}

	public void login() throws IOException {
		System.out.print("서버 ip 입력 : ");
		String ip = sc.next();
		System.out.print("포트번호 입력: ");
		int portnumber = scan();
		System.out.print("id: ");
		String newid = sc.next();
		System.out.print("passeword : ");
		String newpw = sc.next();
		socket = new Socket("localhost", 9999);
		System.out.println("connect!");
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		try {
			fis = new FileInputStream("C:\\Users\\admin\\Desktop\\members.txt");
			dis = new DataInputStream(fis);
			if (dis.available() > 0) {
				while (dis.available() > 0) {
					m.add(new Member(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readInt()));
				}
				dis.close();
				fis.close();
			}
			//System.out.println("1");
		} catch (Exception e) {
			m.add(new Member("root", "Administarator", "root", 0));
			//System.out.println("2");
		}
		int logincheck = 0;
		for (Member p : m) {
			if (p.getId().equals(newid)) {
				if (p.getPassword().equals(newpw)) {
					System.out.println(newid + "님 반갑습니다.");
					logincheck = 1;
					break;
				}
			}
		}
		if (logincheck == 0) {
			int i=0;
			System.out.println("id또는 password가 틀립니다. 다시 시도하세요.");
			for(Member p:m) {
				m.remove(i);
				i++;
			}
		}

		if (logincheck == 1) {
			fis = new FileInputStream("C:\\Users\\admin\\Desktop\\moneyLogdb.txt");
			dis = new DataInputStream(fis);
			if (dis.available() > 0) {
				while (dis.available() > 0) {
					ml.add(new MoneyLog(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readInt(), dis.readUTF()));
				}
				dis.close();
				fis.close();
			}
			System.out.println("서버 연결 및 파일지정에 성공하였습니다.");
			out.write("파일 지정 성공\n");
			out.flush();
		}
	}

	public void inputData() throws IOException {
		System.out.println("세부사항입력 입금출금분류 학목명 날짜 금액 사용자명");
		ml.add(new MoneyLog(sc.next(), sc.next(), sc.next(), scan(), sc.next()));
		out.write("가계부 입력\n");
		out.flush();
	}

	public void showData() throws IOException {
		int i = 1;
		System.out.println("번호\t 분류 \t학목명\t 날짜\t 금액\t 사용자명");
		for (MoneyLog p : ml) {
			System.out.println(
					i + "\t" + p.intputoutput + "\t" + p.rname + "\t" + p.date + "\t" + p.price + "\t" + p.atname);
			i++;
		}
		out.write("가계부 출력\n");
		out.flush();
	}

	public void inputMember() throws IOException {
		System.out.println("세부사항 입력: id name password birth");
		m.add(new Member(sc.next(), sc.next(), sc.next(), scan()));
		out.write("회원 입력\n");
		out.flush();
	}

	public void showMember() throws IOException {
		System.out.print("1.나이순 2.나이역순 3. 이름순 4.id순 : ");
		int a = scan();
		if (a == 1) {
			Collections.sort(m, new AgeComparator());
		} else if (a == 2) {
			Collections.sort(m, new AgeReverseComparator());
		} else if (a == 3) {
			Collections.sort(m, new NameComparator());
		} else if (a == 4) {
			Collections.sort(m, new IdComparator());
		}
		show();
		out.write("회원출력\n");
		out.flush();
	}

	public void show() {
		int i = 1;
		System.out.println("번호\tid\tname\tBirth");
		for (Member p : m) {
			System.out.println(i + "\t" + p.id + "\t" + p.name + "\t" + p.birth);
			i++;
		}
	}

	public void updateMember() throws IOException {
		Collections.sort(m, new IdComparator());
		show();
		System.out.print("수정할 정보 선택: ");
		int a = scan();
		System.out.print("수정회원정보 : ");
		Member p = m.get(a-1);
		System.out.println(a + "\t" + p.id + "\t" + p.name + "\t" + p.password + "\t" + p.birth);
		out.write("회원수정\n");
		out.flush();
	}

	public void deleteMember() throws IOException {
		Collections.sort(m, new IdComparator());
		show();
		System.out.print("삭제할 정보 선택: ");
		int a = scan();
		m.remove(a-1);
		out.write("회원삭제\n");
		out.flush();
	}

	public void fileSave() throws IOException {
		fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\members.txt");
		dos = new DataOutputStream(fos);
		for (int i = 0; i < m.size(); i++) {
			dos.writeUTF(m.get(i).getId());
			dos.writeUTF(m.get(i).getName());
			dos.writeUTF(m.get(i).getPassword());
			dos.writeInt(m.get(i).getBirth());
		}
		dos.close();
		fos.close();
		fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\moneyLogdb.txt");
		dos = new DataOutputStream(fos);
		for (int i = 0; i < ml.size(); i++) {
			dos.writeUTF(ml.get(i).getIntputoutput());
			dos.writeUTF(ml.get(i).getRname());
			dos.writeUTF(ml.get(i).getDate());
			dos.writeInt(ml.get(i).getPrice());
			dos.writeUTF(ml.get(i).getAtname());
		}
		dos.close();
		fos.close();
		out.write("Save datafile\n");
		out.flush();
	}

	public static void main(String[] args) {
		new Client();
	}
}

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
			System.out.println("�ٽ� �Է��ϼ���.");
			return -1;
		}
	}

	public void menu() throws IOException {
		int a = -1;
		while (a != 7) {
			System.out.println(
					"0.���� ���� �� �α��� 1.����� ������ �Է� 2.����� ����Ʈ ����3.�ű� ȸ������ �Է� 4.ȸ������Ʈ���� 5.ȸ���������� 6.ȸ���������� 7.����(��������)");
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
		System.out.println("���Ͽ� ���� �Ǿ����ϴ�.");
		System.out.println("����Ǿ����ϴ�.");
		out.write("bye");
		out.flush();
	}

	public void login() throws IOException {
		System.out.print("���� ip �Է� : ");
		String ip = sc.next();
		System.out.print("��Ʈ��ȣ �Է�: ");
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
					System.out.println(newid + "�� �ݰ����ϴ�.");
					logincheck = 1;
					break;
				}
			}
		}
		if (logincheck == 0) {
			int i=0;
			System.out.println("id�Ǵ� password�� Ʋ���ϴ�. �ٽ� �õ��ϼ���.");
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
			System.out.println("���� ���� �� ���������� �����Ͽ����ϴ�.");
			out.write("���� ���� ����\n");
			out.flush();
		}
	}

	public void inputData() throws IOException {
		System.out.println("���λ����Է� �Ա���ݺз� �и�� ��¥ �ݾ� ����ڸ�");
		ml.add(new MoneyLog(sc.next(), sc.next(), sc.next(), scan(), sc.next()));
		out.write("����� �Է�\n");
		out.flush();
	}

	public void showData() throws IOException {
		int i = 1;
		System.out.println("��ȣ\t �з� \t�и��\t ��¥\t �ݾ�\t ����ڸ�");
		for (MoneyLog p : ml) {
			System.out.println(
					i + "\t" + p.intputoutput + "\t" + p.rname + "\t" + p.date + "\t" + p.price + "\t" + p.atname);
			i++;
		}
		out.write("����� ���\n");
		out.flush();
	}

	public void inputMember() throws IOException {
		System.out.println("���λ��� �Է�: id name password birth");
		m.add(new Member(sc.next(), sc.next(), sc.next(), scan()));
		out.write("ȸ�� �Է�\n");
		out.flush();
	}

	public void showMember() throws IOException {
		System.out.print("1.���̼� 2.���̿��� 3. �̸��� 4.id�� : ");
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
		out.write("ȸ�����\n");
		out.flush();
	}

	public void show() {
		int i = 1;
		System.out.println("��ȣ\tid\tname\tBirth");
		for (Member p : m) {
			System.out.println(i + "\t" + p.id + "\t" + p.name + "\t" + p.birth);
			i++;
		}
	}

	public void updateMember() throws IOException {
		Collections.sort(m, new IdComparator());
		show();
		System.out.print("������ ���� ����: ");
		int a = scan();
		System.out.print("����ȸ������ : ");
		Member p = m.get(a-1);
		System.out.println(a + "\t" + p.id + "\t" + p.name + "\t" + p.password + "\t" + p.birth);
		out.write("ȸ������\n");
		out.flush();
	}

	public void deleteMember() throws IOException {
		Collections.sort(m, new IdComparator());
		show();
		System.out.print("������ ���� ����: ");
		int a = scan();
		m.remove(a-1);
		out.write("ȸ������\n");
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

package test530;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	ArrayList<Movie> e = new ArrayList<Movie>(10);
	int check = 0;
	FileInputStream fis = null;
	DataInputStream dis = null;
	FileOutputStream fos = null;
	DataOutputStream dos = null;

	public int scan() {
		try {
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println("�ٽ� �Է��ϼ���");
			return -1;
		}
	}

	public void menu() throws IOException {
		int a = -1;
		while (a != 7) {
			System.out.println("1.���������� �Է� 2.��������Ʈ���� 3.���������ͻ��� 4.���� �¼��� ���� 5.������������������ 6.���������ͷε� 7.����");
			a = scan();
			if (a == 1) {
				datainput();
			} else if (a == 2) {
				System.out.print("1.��¥�� 2.������");
				int v = scan();
				if (v == 1) {
					Collections.sort(e, new SortDate());
					show();
				} else if (v == 2) {
					Collections.sort(e, new SortTitle());
					show();
				}
			} else if (a == 3) {
				delete();
			} else if (a == 4) {
				updateseat();
			} else if (a == 5) {
				filesave();
			} else if (a == 6) {
				dataloading();
			}
		}
	}

	public void datainput() {
		Scanner sc = new Scanner(System.in);
		String title, date, director, actor;
		int price, seat, ticketprice;
		System.out.println("������������ m:��ȭ");
		String a = sc.next();
		if (a.equals("m")) {
			System.out.println("���λ��� �Է�: ������ ��¥ ���ݾ� ǥ�ݾ� �¼��� ������ ���λ���");
			title = sc.next();
			date = sc.next();
			price = scan();
			ticketprice = scan();
			seat = scan();
			director = sc.next();
			actor = sc.next();
			e.add(new Movie(title, date, price, seat, ticketprice, director, actor));
			check++;
		}
	}

	public void show() {
		System.out.println("��ȣ\t������\t�������� \t��¥ \t���ݾ�(õ��)\tǥ�ݾ�(õ��)\t�¼���\t������ ���λ���");
		for (int i = 0; i < e.size(); i++) {
			System.out.println((i + 1) + "\t" + e.get(i).title + "\t" + "Moive" + "\t" + e.get(i).date + "\t"
					+ e.get(i).price + "\t" + e.get(i).ticketprice + "\t" + e.get(i).seat + "\t"
					+ e.get(i).getDirector() + "\t" + e.get(i).getActor());
		}
	}

	public void delete() {
		show();
		System.out.print("��ȣ ����: ");
		int a = scan();
		if (0 < a && a <= e.size()) {
			e.remove(a - 1);
			System.out.println(a + "�� �����͸� �����Ͽ����ϴ�.");
		} else
			System.out.println(a + "��ȣ�� �����ϴ�.");
	}

	public void updateseat() {
		show();
		System.out.print("���� ��ȣ ����: ");
		int a = scan();
		System.out.println("���� �¼�����" + e.get(a).seat + "�Դϴ�. ���ο� �¼�����? ");
		int b = scan();
		e.get(a).setSeat(b);
	}

	public void filesave() throws IOException {
		file();
		System.out.println("���������͸� a.txt ���Ͽ� �����Ͽ����ϴ�.");
	}

	public void file() throws IOException {
		fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\a.txt");
		dos = new DataOutputStream(fos);
		for (int i = 0; i < e.size(); i++) {
			dos.writeUTF(e.get(i).getTitle());
			dos.writeUTF(e.get(i).getDate());
			dos.writeInt(e.get(i).getPrice());
			dos.writeInt(e.get(i).getTicketprice());
			dos.writeInt(e.get(i).getSeat());
			dos.writeUTF(e.get(i).getDirector());
			dos.writeUTF(e.get(i).getActor());
		}
		dos.close();
		fos.close();
	}

	public void dataloading() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����̸� �Է�: ");
		String a = sc.next();
		System.out.println(a + "���Ϸ� ���� �����͸� �ε��Ͽ����ϴ�.");
		fis = new FileInputStream("C:\\Users\\admin\\Desktop\\a.txt");
		dis = new DataInputStream(fis);
		if (dis.available() > 0) {
			while (dis.available() > 0) {
				e.add(new Movie(dis.readUTF(), dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt(),
						dis.readUTF(), dis.readUTF()));
			}
		}
		dis.close();
		fis.close();
	}

	public static void main(String[] args) throws IOException {
		Main test = new Main();
		test.menu();
		System.out.println("����Ǿ����ϴ�.");
	}
}

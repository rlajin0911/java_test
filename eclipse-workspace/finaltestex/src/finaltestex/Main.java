package finaltestex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	ArrayList<Book> b = new ArrayList<Book>(10);
	FileInputStream fis = null;
	DataInputStream dis = null;
	FileOutputStream fos = null;
	DataOutputStream dos = null;
	HashMap<String, Book> hmap = new HashMap<String, Book>();
	String filename = null;

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
		while (a != 6) {
			System.out.println(
					"0. ���� ������ ���� ���� �� ���� ����, 1. ���� ������ �Է� 2.��������Ʈ ���� 3.���� ������ ���� 4.�������� �˻� 5.������������������ 6.����(��������)");
			a = scan();
			if (a == 0) {
				file();
			} else if (a == 1) {
				dataInput();
			} else if (a == 2) {
				showList();
			} else if (a == 3) {
				dataDelete();
			} else if (a == 4) {
				search();
			} else if (a == 5) {
				dataSave();
			}
		}
		fileSave();
		System.out.println("���� �Ǿ����ϴ�.");
	}

	public void file() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ip �Է�: ");
		//String serverip = sc.next();
		System.out.print("��Ʈ ��ȣ �Է�: ");
		//int portnumber = scan();
		System.out.print("�����̸� : ");
		//Socket so=new Socket(serverip,portnumber);
		filename = sc.next();
		System.out.println(filename + "������ �н��ϴ�.");
		fis = new FileInputStream("C:\\Users\\admin\\Desktop\\" + filename);
		dis = new DataInputStream(fis);
		if (dis.available() > 0) {
			while (dis.available() > 0) {
				int inputprice, inputcount;
				String inputtitle, inputdate, inputauthor;
				inputtitle = dis.readUTF();
				inputdate = dis.readUTF();
				inputprice = dis.readInt();
				inputauthor = dis.readUTF();
				inputcount = dis.readInt();
				Book input = new Book(inputtitle, inputdate, inputprice, inputauthor, inputcount);
				b.add(input);
				hmap.put(inputtitle, input);
			}
		}
		dis.close();
		fis.close();
		System.out.println("���� ���� �� ���� ������ �����Ͽ����ϴ�.");
	}

	public void dataInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���λ��� �Է�: ���� ��¥ ���� ���� �����Ǽ� ");
		String title = sc.next();
		Book input = new Book(title, sc.next(), scan(), sc.next(), scan());
		b.add(input);
		hmap.put(title, input);
	}

	public void showList() {
		System.out.println("1. ���ݼ� 2. ���ݿ�������  3. ����� ����");
		int a = scan();
		if (a == 1) {
			Collections.sort(b, new Pricecomparator());
		} else if (a == 2) {
			Collections.sort(b, new PriceReverseComparator());
		} else if (a == 3) {
			Collections.sort(b, new TitleCompartor());
		}
		show();
	}

	public void show() {
		int i = 1;
		System.out.println("��ȣ\t����\t��¥\t����\t����\t�����Ǽ�");
		for (Book p : b) {
			System.out.println(i + "\t" + p.title + "\t" + p.date + "\t" + p.price + "\t" + p.auther + "\t" + p.score);
			i++;
		}
	}

	public void dataDelete() {
		show();
		System.out.print("��ȣ ����: ");
		int a = scan();
		if (b.get(a - 1) != null) {
			b.remove(a - 1);
			System.out.println(a + "�� �����͸� �����Ͽ����ϴ�.");
		}
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����: ");
		String a = sc.next();
		Book p = hmap.get(a);
		System.out.println("��ȣ\t����\t��¥\t����\t����\t�����Ǽ�");
		System.out.println(0 + "\t" + p.title + "\t" + p.date + "\t" + p.price + "\t" + p.auther + "\t" + p.score);
	}

	public void dataSave() throws IOException {
		System.out.println("���������͸� 0���� ������ ���Ͽ� ���� ���������Ͽ����ϴ�.");
		fileSave();
	}

	public void fileSave() throws IOException {
		fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\" + filename);
		dos = new DataOutputStream(fos);
		for (int i = 0; i < b.size(); i++) {
			dos.writeUTF(b.get(i).getTitle());
			dos.writeUTF(b.get(i).getDate());
			dos.writeInt(b.get(i).getPrice());
			dos.writeUTF(b.get(i).getAuther());
			dos.writeInt(b.get(i).getScore());
		}
		dos.close();
		fos.close();
	}

	public static void main(String[] args) throws IOException {
		Main test = new Main();
		test.menu();
	}
}

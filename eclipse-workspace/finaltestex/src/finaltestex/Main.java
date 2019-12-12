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
			System.out.println("다시 입력하세요");
			return -1;
		}
	}

	public void menu() throws IOException {
		int a = -1;
		while (a != 6) {
			System.out.println(
					"0. 도서 데이터 파일 지정 및 서버 연결, 1. 도서 데이터 입력 2.도서리스트 보기 3.도서 데이터 삭제 4.도서정보 검색 5.도서데이터파일저장 6.종료(파일저장)");
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
		System.out.println("종료 되었습니다.");
	}

	public void file() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("서버 ip 입력: ");
		//String serverip = sc.next();
		System.out.print("포트 번호 입력: ");
		//int portnumber = scan();
		System.out.print("파일이름 : ");
		//Socket so=new Socket(serverip,portnumber);
		filename = sc.next();
		System.out.println(filename + "파일을 읽습니다.");
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
		System.out.println("서버 연결 및 파일 지정에 성공하였습니다.");
	}

	public void dataInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("세부사항 입력: 제목 날짜 가격 저자 보유권수 ");
		String title = sc.next();
		Book input = new Book(title, sc.next(), scan(), sc.next(), scan());
		b.add(input);
		hmap.put(title, input);
	}

	public void showList() {
		System.out.println("1. 가격순 2. 가격역순보기  3. 제목순 보기");
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
		System.out.println("번호\t제목\t날짜\t가격\t저자\t보유권수");
		for (Book p : b) {
			System.out.println(i + "\t" + p.title + "\t" + p.date + "\t" + p.price + "\t" + p.auther + "\t" + p.score);
			i++;
		}
	}

	public void dataDelete() {
		show();
		System.out.print("번호 선택: ");
		int a = scan();
		if (b.get(a - 1) != null) {
			b.remove(a - 1);
			System.out.println(a + "번 데이터를 삭제하였습니다.");
		}
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("제목: ");
		String a = sc.next();
		Book p = hmap.get(a);
		System.out.println("번호\t제목\t날짜\t가격\t저자\t보유권수");
		System.out.println(0 + "\t" + p.title + "\t" + p.date + "\t" + p.price + "\t" + p.auther + "\t" + p.score);
	}

	public void dataSave() throws IOException {
		System.out.println("도서데이터를 0에서 지정한 파일에 저장 수동저장하였습니다.");
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

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
			System.out.println("다시 입력하세요");
			return -1;
		}
	}

	public void menu() throws IOException {
		int a = -1;
		while (a != 7) {
			System.out.println("1.공연데이터 입력 2.공연리스트보기 3.공연데이터삭제 4.개별 좌석수 조정 5.공연데이터파일저장 6.공연데이터로딩 7.종료");
			a = scan();
			if (a == 1) {
				datainput();
			} else if (a == 2) {
				System.out.print("1.날짜순 2.공연명");
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
		System.out.println("공연종류선택 m:영화");
		String a = sc.next();
		if (a.equals("m")) {
			System.out.println("세부사항 입력: 공연명 날짜 계약금액 표금액 좌석수 공연별 세부사항");
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
		System.out.println("번호\t공연명\t공연형태 \t날짜 \t계약금액(천원)\t표금액(천원)\t좌석수\t공연별 세부사항");
		for (int i = 0; i < e.size(); i++) {
			System.out.println((i + 1) + "\t" + e.get(i).title + "\t" + "Moive" + "\t" + e.get(i).date + "\t"
					+ e.get(i).price + "\t" + e.get(i).ticketprice + "\t" + e.get(i).seat + "\t"
					+ e.get(i).getDirector() + "\t" + e.get(i).getActor());
		}
	}

	public void delete() {
		show();
		System.out.print("번호 선택: ");
		int a = scan();
		if (0 < a && a <= e.size()) {
			e.remove(a - 1);
			System.out.println(a + "번 데이터를 삭제하였습니다.");
		} else
			System.out.println(a + "번호가 없습니다.");
	}

	public void updateseat() {
		show();
		System.out.print("공연 번호 선택: ");
		int a = scan();
		System.out.println("현재 좌석수는" + e.get(a).seat + "입니다. 새로운 좌석수는? ");
		int b = scan();
		e.get(a).setSeat(b);
	}

	public void filesave() throws IOException {
		file();
		System.out.println("공연데이터를 a.txt 파일에 저장하였습니다.");
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
		System.out.print("파일이름 입력: ");
		String a = sc.next();
		System.out.println(a + "파일로 부터 데이터를 로딩하였습니다.");
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
		System.out.println("종료되었습니다.");
	}
}

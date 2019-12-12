package min2;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	Event[] e = new Event[10];
	int num = 0;

	public void menu() {
		System.out.println("1.공연 데이터 입력 2. 공연리스트 보기 3.개별 좌석수 조정 4. 모든 표금액 일괄 조정 5. 좌석수점위로 검색 6. 종료");
	}

	public int scan() {
		try {
			Scanner a = new Scanner(System.in);
			return a.nextInt();
		} catch (Exception e) {
			System.out.println("다시 입력하세요.");
			return 0;
		}
	}

	public void Q1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("공연종류는? (m,c,t)");
		String a = scan.next();
		int date, ticketPrice, numOfSeat, actornum;
		String title, actorname, director, actor, singer, stageManager;
		if (a.equals("m")) {
			title = scan.next();
			date = scan();
			ticketPrice = scan();
			numOfSeat = scan();
			actorname = scan.next();
			actornum = scan();
			e[num] = new Musical(title, date, ticketPrice, numOfSeat, actorname, actornum);
			num++;
		} else if (a.equals("c")) {
			title = scan.next();
			date = scan();
			ticketPrice = scan();
			numOfSeat = scan();
			director = scan.next();
			actor = scan.next();
			e[num] = new Movie(title, date, ticketPrice, numOfSeat, director, actor);
			num++;
		} else if (a.equals("t")) {
			title = scan.next();
			date = scan();
			ticketPrice = scan();
			numOfSeat = scan();
			singer = scan.next();
			stageManager = scan.next();
			e[num] = new Concert(title, date, ticketPrice, numOfSeat, singer, stageManager);
			num++;
		}
	}

	public void Q2() {
		System.out.print("1. 날짜순 2.공연명 3.공연명역순 4.좌석수 5.좌석수역순 선텍: ");
		int a = scan();
		if (a == 1) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (e[j + 1] != null) {
						if (e[j].getDate() > e[j + 1].getDate()) {
							Event temp = e[j];
							e[j] = e[j + 1];
							e[j + 1] = temp;
						}
					}
				}
			}
			print();
		} else if (a == 2) {
			Arrays.sort(e,new sortTitle());
			print();
		} else if (a == 3) {
			Arrays.sort(e,new sortTitle2());
			print();
		} else if (a == 4) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (e[j + 1] != null) {
						if (e[j].getNumOfSeat() > e[j + 1].getNumOfSeat()) {
							Event temp = e[j];
							e[j] = e[j + 1];
							e[j + 1] = temp;
						}
					}
				}
			}
			print();
		} else if (a == 5) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (e[j + 1] != null) {
						if (e[j].getNumOfSeat() < e[j + 1].getNumOfSeat()) {
							Event temp = e[j];
							e[j] = e[j + 1];
							e[j + 1] = temp;
						}
					}
				}
			}
			print();
		}
	}

	public void print() {
		System.out.println("번호\t공연형태\t공연명\t날짜\t 표금액(천원)\t좌석수\t공연별세부사항");
		for (int i = 0; i < 10; i++) {
			if (e[i] != null) {
				if (e[i] instanceof Musical) {
					Musical m = (Musical) e[i];
					System.out.println((i + 1) + "\t" + "뮤지컬" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
							+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getActorname() + "\t"
							+ m.getActornum());
				} else if (e[i] instanceof Movie) {
					Movie m = (Movie) e[i];
					System.out.println(
							(i + 1) + "\t" + "영화" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t" + m.getTicketPrice()
									+ "\t\t" + m.getNumOfSeat() + "\t" + m.getDirector() + "\t" + m.getActor());
				} else if (e[i] instanceof Concert) {
					Concert m = (Concert) e[i];
					System.out.println((i + 1) + "\t" + "콘서트" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
							+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getSinger() + "\t"
							+ m.getStageManager());
				}
			}
		}
	}

	public void Q3() {
		print();
		System.out.print("공연 번호 선택: ");
		int a = scan();
		if (e[a - 1] != null) {
			System.out.print("현재 좌석수는" + e[a - 1].getNumOfSeat() + "입니다. 새로운 좌석수는? ");
			int b = scan();
			e[a - 1].setNumOfSeat(b);
		}
	}

	public void Q4() {
		int a = 0;
		while (a != 3) {
			System.out.print("1.표금액 일괄 올림 2. 표금액일괄내림 3.종료 선택:");
			a = scan();
			if (a == 1) {
				System.out.print("일괄올릴 표금액은? ");
				int b = scan();
				for (int i = 0; i < 10; i++) {
					if (e[i] != null) {
						e[i].setTicketPrice(e[i].getTicketPrice() + b);
					}
				}
			} else if (a == 2) {
				System.out.print("일괄내릴 표금액은? ");
				int b = scan();
				for (int i = 0; i < 10; i++) {
					if (e[i] != null) {
						e[i].setTicketPrice(e[i].getTicketPrice() - b);
					}
				}
			}
		}
	}

	public void Q5() {
		System.out.print("검색 할 좌석 수 최소 최대 범위를 입력하세요. ");
		int a = scan();
		int b = scan();
		for (int i = 0; i < 10; i++) {
			if (e[i] != null) {
				if (a <= e[i].getNumOfSeat() && e[i].getNumOfSeat() <= b)
					if (e[i] instanceof Musical) {
						Musical m = (Musical) e[i];
						System.out.println((i + 1) + "\t" + "뮤지컬" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
								+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getActorname() + "\t"
								+ m.getActornum());
					} else if (e[i] instanceof Movie) {
						Movie m = (Movie) e[i];
						System.out.println((i + 1) + "\t" + "영화" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
								+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getDirector() + "\t"
								+ m.getActor());
					} else if (e[i] instanceof Concert) {
						Concert m = (Concert) e[i];
						System.out.println((i + 1) + "\t" + "콘서트" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
								+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getSinger() + "\t"
								+ m.getStageManager());
					}
			}
		}
	}

	public static void main(String[] args) {
		int a = 0;
		Menu test = new Menu();
		while (a != 6) {
			test.menu();
			a = test.scan();
			if (a == 1) {
				test.Q1();
			} else if (a == 2) {
				test.Q2();
			} else if (a == 3) {
				test.Q3();
			} else if (a == 4) {
				test.Q4();
			} else if (a == 5) {
				test.Q5();
			}
		}
		System.out.println("종료되었습니다.");
	}
}

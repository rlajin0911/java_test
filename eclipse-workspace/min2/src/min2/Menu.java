package min2;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	Event[] e = new Event[10];
	int num = 0;

	public void menu() {
		System.out.println("1.���� ������ �Է� 2. ��������Ʈ ���� 3.���� �¼��� ���� 4. ��� ǥ�ݾ� �ϰ� ���� 5. �¼��������� �˻� 6. ����");
	}

	public int scan() {
		try {
			Scanner a = new Scanner(System.in);
			return a.nextInt();
		} catch (Exception e) {
			System.out.println("�ٽ� �Է��ϼ���.");
			return 0;
		}
	}

	public void Q1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("����������? (m,c,t)");
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
		System.out.print("1. ��¥�� 2.������ 3.�������� 4.�¼��� 5.�¼������� ����: ");
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
		System.out.println("��ȣ\t��������\t������\t��¥\t ǥ�ݾ�(õ��)\t�¼���\t���������λ���");
		for (int i = 0; i < 10; i++) {
			if (e[i] != null) {
				if (e[i] instanceof Musical) {
					Musical m = (Musical) e[i];
					System.out.println((i + 1) + "\t" + "������" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
							+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getActorname() + "\t"
							+ m.getActornum());
				} else if (e[i] instanceof Movie) {
					Movie m = (Movie) e[i];
					System.out.println(
							(i + 1) + "\t" + "��ȭ" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t" + m.getTicketPrice()
									+ "\t\t" + m.getNumOfSeat() + "\t" + m.getDirector() + "\t" + m.getActor());
				} else if (e[i] instanceof Concert) {
					Concert m = (Concert) e[i];
					System.out.println((i + 1) + "\t" + "�ܼ�Ʈ" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
							+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getSinger() + "\t"
							+ m.getStageManager());
				}
			}
		}
	}

	public void Q3() {
		print();
		System.out.print("���� ��ȣ ����: ");
		int a = scan();
		if (e[a - 1] != null) {
			System.out.print("���� �¼�����" + e[a - 1].getNumOfSeat() + "�Դϴ�. ���ο� �¼�����? ");
			int b = scan();
			e[a - 1].setNumOfSeat(b);
		}
	}

	public void Q4() {
		int a = 0;
		while (a != 3) {
			System.out.print("1.ǥ�ݾ� �ϰ� �ø� 2. ǥ�ݾ��ϰ����� 3.���� ����:");
			a = scan();
			if (a == 1) {
				System.out.print("�ϰ��ø� ǥ�ݾ���? ");
				int b = scan();
				for (int i = 0; i < 10; i++) {
					if (e[i] != null) {
						e[i].setTicketPrice(e[i].getTicketPrice() + b);
					}
				}
			} else if (a == 2) {
				System.out.print("�ϰ����� ǥ�ݾ���? ");
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
		System.out.print("�˻� �� �¼� �� �ּ� �ִ� ������ �Է��ϼ���. ");
		int a = scan();
		int b = scan();
		for (int i = 0; i < 10; i++) {
			if (e[i] != null) {
				if (a <= e[i].getNumOfSeat() && e[i].getNumOfSeat() <= b)
					if (e[i] instanceof Musical) {
						Musical m = (Musical) e[i];
						System.out.println((i + 1) + "\t" + "������" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
								+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getActorname() + "\t"
								+ m.getActornum());
					} else if (e[i] instanceof Movie) {
						Movie m = (Movie) e[i];
						System.out.println((i + 1) + "\t" + "��ȭ" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
								+ m.getTicketPrice() + "\t\t" + m.getNumOfSeat() + "\t" + m.getDirector() + "\t"
								+ m.getActor());
					} else if (e[i] instanceof Concert) {
						Concert m = (Concert) e[i];
						System.out.println((i + 1) + "\t" + "�ܼ�Ʈ" + "\t" + m.getTitle() + "\t" + m.getDate() + "\t"
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
		System.out.println("����Ǿ����ϴ�.");
	}
}

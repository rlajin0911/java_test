package kje;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Collections;

public class Main {
	ArrayList<Robot> r = new ArrayList<Robot>(10);
	Map<String, Robot> map = new HashMap<String, Robot>();
	Map<Integer, Robot> tmap = new TreeMap<Integer, Robot>();
	int check = 0;

	public int scan() {
		try {
			Scanner a = new Scanner(System.in);
			return a.nextInt();
		} catch (Exception e) {
			System.out.println("다시 입력하세요!");
			return 0;
		}
	}

	public void Q1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("제품종류는? (CleaningRobot:c , DogRobot:d");

		int id, x, y, distance, price, cleaningPower, barkPower;
		String robotname;
		String a = sc.next();
		if (a.equals("c")) {
			System.out.print("세부사항 입력: ");
			id = scan();
			robotname = sc.next();
			price = scan();
			cleaningPower = scan();
			CleaningRobot c = new CleaningRobot(scan(), sc.next(), 20, 20, 3, scan(), scan());
			r.add(check, c);
			check++;
			map.put(robotname, c);
			tmap.put(id, c);
		} else if (a.equals("d")) {
			System.out.print("세부사항 입력: ");
			id = scan();
			robotname = sc.next();
			price = scan();
			barkPower = scan();
			DogRobot c = new DogRobot(scan(), sc.next(), 30, 30, 10, scan(), scan());
			r.add(check, c);
			check++;
			map.put(robotname, c);
			tmap.put(id, c);
		} else
			System.out.println("다시 입력하세요");
	}

	public void Q2() {
		System.out.print("1.로봇명순 정렬 2.가격순정렬 3.id순 정렬: ");
		int a = scan();
		if (a == 1) {
			Collections.sort(r, new SortName());
			print();
		} else if (a == 2) {
			Collections.sort(r, new SortPrice());
			print();
		} else if (a == 3) {
			Collections.sort(r, new SortId());
			print();
		}
	}

	public void print() {
		System.out.println("번호 \t id \t 종류 \t\t Robot명 \t x \t y \t price \t distance \t etc");
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i) != null) {
				if (r.get(i) instanceof CleaningRobot) {
					CleaningRobot c = (CleaningRobot) r.get(i);
					System.out.println((i + 1) + "\t" + c.getId() + "\tCleaningRobot\t" + c.getRobotname() + "\t\t"
							+ c.getX() + "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
							+ c.getCleaningPower());
				} else if (r.get(i) instanceof DogRobot) {
					DogRobot c = (DogRobot) r.get(i);
					System.out.println((i + 1) + "\t" + c.getId() + "\tDogRobot\t" + c.getRobotname() + "\t\t"
							+ c.getX() + "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
							+ c.getBarkPower());
				}
			}
		}
	}

	public void Q3() {
		print();
		System.out.print("로봇 id 선택:");
		int a = scan();
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i) != null) {
				if (r.get(i).getId() == a) {
					if (r.get(i) instanceof CleaningRobot) {
						CleaningRobot c = (CleaningRobot) r.get(i);
						c.move(r.get(i).distance);
					} else if (r.get(i) instanceof DogRobot) {
						DogRobot c = (DogRobot) r.get(i);
						c.move(r.get(i).distance);
					}
				}
			}
		}
	}

	public void Q4() {
		Collections.sort(r, new SortId());
		print();
		System.out.print("삭제한 Robot의 id는? ");
		int a = scan();
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i) != null) {
				if (r.get(i).getId() == a) {
					System.out.println("id" + r.get(i).getId() + "번 로봇을 삭제하였습니다.");
					r.remove(i);
				}
			}
		}
	}

	public void Q5() {
		System.out.print("가격 범위:  ");
		int a = scan();
		int b = scan();
		System.out.println("번호 \t id \t 종류 \t\t Robot명 \t x \t y \t price \t distance \t etc");
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i) != null) {
				if (a <= r.get(a).price && r.get(a).price <= b) {
					if (r.get(i) instanceof CleaningRobot) {
						CleaningRobot c = (CleaningRobot) r.get(i);
						System.out.println((i + 1) + "\t" + c.getId() + "\tCleaningRobot\t" + c.getRobotname() + "\t\t"
								+ c.getX() + "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
								+ c.getCleaningPower());
					} else if (r.get(i) instanceof DogRobot) {
						DogRobot c = (DogRobot) r.get(i);
						System.out.println((i + 1) + "\t" + c.getId() + "\tDogRobot\t" + c.getRobotname() + "\t\t"
								+ c.getX() + "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
								+ c.getBarkPower());
					}
				}
			}
		}
	}

	public void Q6() {
		Scanner scan = new Scanner(System.in);
		System.out.print("1. 이름으로 검색(Hashmap사용) 2.id로 검색(TreeMap사용)");
		int a = scan();
		if (a == 1) {
			System.out.print("이름은?");
			String b = scan.next();
			for (Entry<String, Robot> entry : map.entrySet()) {
				if (entry.getKey().equals(b)) {
					System.out.println("id \t 종류 \t\t Robot명 \t x \t y \t price \t distance \t etc");
					if (entry.getValue() instanceof CleaningRobot) {
						CleaningRobot c = (CleaningRobot) entry.getValue();
						System.out.println(c.getId() + "\tCleaningRobot\t" + c.getRobotname() + "\t\t" + c.getX()
								+ "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
								+ c.getCleaningPower());
					} else if (entry.getValue() instanceof DogRobot) {
						DogRobot c = (DogRobot) entry.getValue();
						System.out.println(c.getId() + "\tDogRobot\t" + c.getRobotname() + "\t\t" + c.getX()
								+ "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
								+ c.getBarkPower());
					}
				}
			}
		} else if (a == 2) {
			System.out.print("id는?");
			int d = scan();
			for (Entry<String, Robot> entry : map.entrySet()) {
				if (entry.getKey().equals(d)) {
					System.out.println("id \t 종류 \t\t Robot명 \t x \t y \t price \t distance \t etc");
					if (entry.getValue() instanceof CleaningRobot) {
						CleaningRobot c = (CleaningRobot) entry.getValue();
						System.out.println("\t" + c.getId() + "\tCleaningRobot\t" + c.getRobotname() + "\t" + c.getX()
								+ "\t" + c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t"
								+ c.getCleaningPower());
					} else if (entry.getValue() instanceof DogRobot) {
						DogRobot c = (DogRobot) entry.getValue();
						System.out.println("\t" + c.getId() + "\tDogRobot\t" + c.getRobotname() + "\t" + c.getX() + "\t"
								+ c.getY() + "\t" + c.getPrice() + "\t" + c.getDistance() + "\t" + c.getBarkPower());
					}
				}
			}
		}
	}

	public void menu() {
		int a = 0;
		while (a != 7) {
			System.out.println("1.로봇 데이터 입력 2.로봇리스트보기 3.개별 로봇이동 4.로봇삭제 5.로봇 가격 범위로 검색 6.로봇검색 7. 종료");
			a = scan();
			if (a == 1) {
				Q1();
			} else if (a == 2) {
				Q2();
			} else if (a == 3) {
				Q3();
			} else if (a == 4) {
				Q4();
			} else if (a == 5) {
				Q5();
			} else if (a == 6) {
				Q6();
			}
		}

	}

	public static void main(String[] args) {
		Main test = new Main();
		test.menu();
		System.out.println("종료되었습니다.");
	}
}

package test426;

import java.util.Scanner;

public class Menu {
	Product[] p = new Product[10];

	public void menu() {
		System.out.println("1. 제품 데이터 입력 2. 제품리스트 보기 3. 개별 공연 계약금액 조정 4. 모든 공연 계약금액 일관 조정 5. 계약금액 범위로 검색 6. 종료");
	}

	public int Scan() {
		try {
			Scanner scan = new Scanner(System.in);
			return scan.nextInt();
		} catch (Exception e) {
			System.out.println("다시 입력해 주세요");
			return 0;
		}
	}

	public void Q1() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("제품 종류는? c,r,a");
			int date, numOfStock, price, i = 0;
			String model, compary, speed, inch, size, type, M, YN;
			String a = scan.next();
			if (a.equals("c")) {
				System.out.print("세부사항 입력: ");
				model = scan.next();
				compary = scan.next();
				date = Scan();
				numOfStock = Scan();
				price = Scan();
				speed = scan.next();
				inch = scan.next();
				p[i] = new CPU(model, compary, date, numOfStock, price, speed, inch);
				i++;
				break;
			} else if (a.equals("r")) {
				System.out.print("세부사항 입력: ");
				model = scan.next();
				compary = scan.next();
				date = Scan();
				numOfStock = Scan();
				price = Scan();
				size = scan.next();
				type = scan.next();
				p[i] = new Refrigerator(model, compary, date, numOfStock, price, size, type);
				i++;
				break;
			} else if (a.equals("a")) {
				System.out.print("세부사항 입력: ");
				model = scan.next();
				compary = scan.next();
				date = Scan();
				numOfStock = Scan();
				price = Scan();
				M = scan.next();
				YN = scan.next();
				p[i] = new Audio(model, compary, date, numOfStock, price, M, YN);
				i++;
				break;
			} else
				System.out.println("다시 입력하세요.");
		}
	}

	public void Q2() {
		System.out.println("번호\t제품명\t제조사\t입고날짜\t재고수량\t가격\t제품별 세수사랑");
		for (int i = 0; i < 10; i++) {
			if (p[i] != null) {
				if (p[i] instanceof CPU) {
					CPU c = (CPU) p[i];
					System.out.println((i + 1) + "\t"+c.getModel() + "\t"+c.getCompany() +"\t"+ c.getDate() + "\t"+c.getNumOfstock()
							+ "\t"+c.getPrice() + "\t"+c.getSpeed() + "\t"+c.getInch());
				}
				if (p[i] instanceof Refrigerator) {
					Refrigerator r = (Refrigerator) p[i];
					System.out.println((i + 1) + "\t"+r.getModel() + "\t"+r.getCompany() + "\t"+r.getDate() +"\t"+ r.getNumOfstock()
							+ "\t"+r.getPrice() + "\t"+r.getSize() + "\t"+r.getType());
				}
				if (p[i] instanceof Audio) {
					Audio a = (Audio) p[i];
					System.out.println((i + 1) + "\t"+a.getModel() + "\t"+a.getCompany() + "\t"+a.getDate() + "\t"+a.getNumOfstock()
							+"\t"+ a.getPrice() + "\t"+a.getM() +"\t"+ a.getYN());
				}
			}
		}
	}

	public void datelist(int a) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

			}
		}
	}

	public void Q3() {
		while (true) {
			Q2();
			System.out.println("제품 번호 선택:");
			int a = Scan();
			if (a == 0)
				;
			else {
				int b;
				if (p[a - 1] != null) {
					if (p[a - 1] instanceof CPU) {
						CPU c = (CPU) p[a - 1];
						System.out.print("현재 계약금액은 " + c.getPrice() + "입니다. 새로운 계약금액은?");
						b = Scan();
						c.setPrice(b);
						break;
					} else if (p[a - 1] instanceof Refrigerator) {
						Refrigerator c = (Refrigerator) p[a - 1];
						System.out.print("현재 계약금액은 " + c.getPrice() + "입니다. 새로운 계약금액은?");
						b = Scan();
						c.setPrice(b);
						break;
					} else if (p[a - 1] instanceof Audio) {
						Audio c = (Audio) p[a - 1];
						System.out.print("현재 계약금액은 " + c.getPrice() + "입니다. 새로운 계약금액은?");
						b = Scan();
						c.setPrice(b);
						break;
					}
				} else
					System.out.println("다시 입력하세요.");
			}
		}
	}

	public void Q4() {
		while (true) {
			System.out.println("1. 제품가격 일괄올림 2.제품가격일관내림 3. 취소");
			System.out.print("선택: ");
			int a = Scan();
			if (a == 0)
				;
			else {
				if (a == 1) {
					while (true) {
						System.out.print("일관올릴 제품가격은?");
						int b = Scan();
						if (b == 0)
							;
						else {
							for (int i = 0; i < 10; i++) {
								if (p[i] != null) {
									if (p[i] instanceof CPU) {
										CPU c = (CPU) p[i];
										c.setPrice(c.getPrice()+b);
									}
								} else if (p[i] != null) {
									if (p[i] instanceof Audio) {
										Audio c = (Audio) p[i];
										c.setPrice(c.getPrice()+b);
									}
								} else if (p[i] != null) {
									if (p[i] instanceof Refrigerator) {
										Refrigerator c = (Refrigerator) p[i];
										c.setPrice(c.getPrice()+b);
									}
								}
							}
							break;
						}
					}
					break;
				} else if (a == 2) {
					while (true) {
						System.out.print("일관내릴 제품가격은?");
						int b = Scan();
						if (b == 0)
							;
						else {
							for (int i = 0; i < 10; i++) {
								if (p[i] != null) {
									if (p[i] instanceof CPU) {
										CPU c = (CPU) p[i];
										c.setPrice(c.getPrice()-b);
									}
								} else if (p[i] != null) {
									if (p[i] instanceof Audio) {
										Audio c = (Audio) p[i];
										c.setPrice(c.getPrice()-b);
									}
								} else if (p[i] != null) {
									if (p[i] instanceof Refrigerator) {
										Refrigerator c = (Refrigerator) p[i];
										c.setPrice(c.getPrice()-b);
									}
								}
							}
						}
						break;
					}
					break;
				} else if (a == 3) {
					System.out.println("취소하였습니다.");
					break;
				} else
					System.out.println("다시 입력하세요.");
			}
		}
	}

	public void Q5() {
		while (true) {
			System.out.print("검색 할 가격 최소 최대 범위를 입력하세요: ");
			int a = Scan();
			int b = Scan();
			if (a == 0 || b == 0)
				;
			else {
				System.out.println("번호\t제품명\t제조사\t입고날짜\t재고수량\t가격\t제품별 세수사랑");
				for (int i = 0; i < 10; i++) {
					if (p[i] != null) {
						if (p[i] instanceof CPU) {
							CPU c = (CPU) p[i];
							if (a <= c.getPrice() && c.getPrice() <= b) {
								System.out.println((i + 1) + "\t"+c.getModel() + "\t"+c.getCompany() + "\t"+c.getDate()
										+ "\t"+c.getNumOfstock() + "\t"+c.getPrice() + "\t"+c.getSpeed() +"\t"+ c.getInch());
							}
						} else if (p[i] instanceof Refrigerator) {
							Refrigerator c = (Refrigerator) p[i];
							if (a <= c.getPrice() && c.getPrice() <= b) {
								System.out.println((i + 1) + "\t"+c.getModel() + "\t"+c.getCompany() + "\t"+c.getDate()
										+ "\t"+c.getNumOfstock() + "\t"+c.getPrice() +"\t"+ c.getSize() + "\t"+c.getType());
							}
						} else if (p[i] instanceof Audio) {
							Audio c = (Audio) p[i];
							if (a <= c.getPrice() && c.getPrice() <= b) {
								System.out.println((i + 1) + "\t"+c.getModel() + "\t"+c.getCompany() + "\t"+c.getDate()
										+ "\t"+c.getNumOfstock() + "\t"+c.getPrice() + "\t"+c.getM() + "\t"+c.getYN());
							}
						}
					}
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu test = new Menu();
		int a = 0;
		while (a != 6) {
			test.menu();
			a = test.Scan();
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

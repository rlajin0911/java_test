package bank;

import java.util.Scanner;

public class pu {
	 int sum=0;
	public void input() {
		System.out.print("예금액> ");
		int num=scanint();
		sum+=num;
	}
	public void output() {
		System.out.print("출금액> ");
		int num=scanint();
		if(sum-num<0) System.out.println("잔고가 부족하여 출금할 수 없습니다.");
		else sum -= num;
	}
	public int menu() {
		System.out.println("1.예금  2.출금 3.잔고 4.종료");		
		System.out.print("선택> ");
		int num=scanint();
		return num;
	}
	public int scanint() {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		return num;
	}
	public static void main(String[] args) {
		pu Hello=new pu();
		int num;
		while(true) {
			try {
				num=Hello.menu();
				if(num==1) Hello.input();
				else if(num==2) Hello.output();
				else if(num==3) System.out.println("잔고> "+Hello.sum);
				else if(num==4) break;
			}
			catch(Exception e) {
				System.out.println("정수가 아닌것을 입력하였습니다.");
			}
		}
	}
}
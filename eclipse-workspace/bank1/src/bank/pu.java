package bank;

import java.util.Scanner;

public class pu {
	 int sum=0;
	public void input() {
		System.out.print("���ݾ�> ");
		int num=scanint();
		sum+=num;
	}
	public void output() {
		System.out.print("��ݾ�> ");
		int num=scanint();
		if(sum-num<0) System.out.println("�ܰ� �����Ͽ� ����� �� �����ϴ�.");
		else sum -= num;
	}
	public int menu() {
		System.out.println("1.����  2.��� 3.�ܰ� 4.����");		
		System.out.print("����> ");
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
				else if(num==3) System.out.println("�ܰ�> "+Hello.sum);
				else if(num==4) break;
			}
			catch(Exception e) {
				System.out.println("������ �ƴѰ��� �Է��Ͽ����ϴ�.");
			}
		}
	}
}
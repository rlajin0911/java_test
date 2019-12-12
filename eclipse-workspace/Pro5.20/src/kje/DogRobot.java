package kje;

import java.util.Scanner;

public class DogRobot extends Robot{
	int barkPower=3;
	void barkStart() {
		System.out.println("barkPower"+barkPower+"���� ¢�� �����߽��ϴ�.");
	}
	void brakStop() {
		System.out.println("barkPower"+barkPower+"���� ¢�ٰ� ���߾����ϴ�.");
	}
	public DogRobot(int id, String robotname, int x, int y, int distance, int price,int barkPower) {
		super(id, robotname, x, y, distance, price);
		this.barkPower = barkPower;
	}
	public int getBarkPower() {
		return barkPower;
	}
	public void setBarkPower(int barkPower) {
		this.barkPower = barkPower;
	}
	@Override
	int move(int direction) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("�̵�(��:1 �� :2 �� :3 ��:4) :");
		int b=scan.nextInt();
		System.out.print("DogRobot"+getRobotname()+"�� "+getX()+"\t"+getY()+"��ġ���� ");
		if(b==1&&getY()-direction>0) {
			setY(getY()-direction);
		}else if(b==2&&getY()+direction<200) {
			setY(getY()+direction);
		}else if(b==3&&getX()-direction>0) {
			setX(getX()-direction);
		}else if(b==4&&getX()+direction<200) {
			setX(getX()+direction);
		}
		System.out.println(getX()+"\t"+getY()+"�� �̵��Ͽ����ϴ�.");
		return 0;
	}
}
package kje;

import java.util.Scanner;

public class CleaningRobot extends Robot{
	int cleaningPower=10;
	void cleaningStart() {
		System.out.println("cleaningPower"+cleaningPower+"���� û�Ҹ� �����߽��ϴ�.");
	}
	void cleaningStop() {
		System.out.println("cleaningPower"+cleaningPower+"�� û�Ҹ� ���߾����ϴ�.");
	}
	public CleaningRobot(int id, String robotname, int x, int y, int distance, int price,
			int cleaningPower) {
		super(id, robotname, x, y, distance, price);
		this.cleaningPower = cleaningPower;
	}
	public int getCleaningPower() {
		return cleaningPower;
	}
	public void setCleaningPower(int cleaningPower) {
		this.cleaningPower = cleaningPower;
	}
	@Override
	int move(int direction) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("�̵�(��:1 �� :2 �� :3 ��:4) :");
		int b=scan.nextInt();
		System.out.print("CleaningRobot"+getRobotname()+"�� "+getX()+"\t"+getY()+"��ġ���� ");
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

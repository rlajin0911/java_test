package kje;

import java.util.Scanner;

public class CleaningRobot extends Robot{
	int cleaningPower=10;
	void cleaningStart() {
		System.out.println("cleaningPower"+cleaningPower+"으로 청소를 시작했습니다.");
	}
	void cleaningStop() {
		System.out.println("cleaningPower"+cleaningPower+"의 청소를 멈추었습니다.");
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
		System.out.print("이동(상:1 하 :2 좌 :3 우:4) :");
		int b=scan.nextInt();
		System.out.print("CleaningRobot"+getRobotname()+"이 "+getX()+"\t"+getY()+"위치에서 ");
		if(b==1&&getY()-direction>0) {
			setY(getY()-direction);
		}else if(b==2&&getY()+direction<200) {
			setY(getY()+direction);
		}else if(b==3&&getX()-direction>0) {
			setX(getX()-direction);
		}else if(b==4&&getX()+direction<200) {
			setX(getX()+direction);
		}
		System.out.println(getX()+"\t"+getY()+"로 이동하였습니다.");
		return 0;
	}
}

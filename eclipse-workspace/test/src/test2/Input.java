package test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	ArrayList<Robot> robotlist =new ArrayList<Robot>;
	Input() {
		int sel=0;
		LoadFile(robotlist);
		do {
			printMenu(1);
			sel=conStr(scanf());
			if(sel==1) {
				System.out.println("다시");
				continue;
			}
			switch(sel) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
			SaveFile(robotlist);
		}while(sel!=8);
	}
	 Boolean SaveFile(ArrayList<Robot> list) {
		// TODO Auto-generated method stub
		try {
			DataOutputStream out =new DataOutputStream(new FileOutputStream("1.txt"));
			for(Robot robot: list) {
				if(robot instanceof CleaningRobot) {
					CleaningRobot temp=((CleaningRobot)robot);
					out.writeUTF("1");
					out.writeUTF(temp.getId()+"");
					out.writeUTF(temp.getRobotname());
					out.writeUTF(temp.getX()+"");
					out.writeUTF(temp.getY()+"");
					out.writeUTF(temp.getPrice()+"");
					out.writeUTF(temp.getCleaningPower()+"");
				}
			}
			out.close();
		}catch(Exception e) {
			
		}
		return true;
	}
	 Boolean LoadFile(ArrayList<Robot> robotlist2) {
			// TODO Auto-generated method stub
		 try {
			 DataInputStream in =new DataInputStream(new FileInputStream("1.txt"));
			 String[] data=new String[6];
			 while(true) {
				 for(int i=0;i<6;i++) {
					 data[i]=in.readUTF();
				 }
				 if(Integer.parseInt(data[0])==1) {
					 CleaningRobot robot= new CleaningRobot(robot.getId(),robot.getRobotname(),robot.getX(),robot.getY(), robot.getDistance(),robot.getPrice(), robot.getX(),robot.getY(), robot.getDistance(),
							robot.getCleaningPower())
				 }
			 }
		 }catch(Exception e) {
			 
		 }
		 return true;
		}
	 int conStr(String data) {
		// TODO Auto-generated method stub
		 int a;
		 try {
			 a=Integer.parseInt(data);
		 }catch(Exception e){
			 a=-1;
		 }
		return a;
	}
	String scanf() {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		String sel=in.nextLine();
		return sel;
	}
	 void printMenu(String mode) {
		// TODO Auto-generated method stub
		if(mode.compareTo("1")==0) {
			System.out.println("1. 로봇추가");
			System.out.println("2. 로봇삭제");
			System.out.println("3. 로봇 리스트보기");
			System.out.println("4. 로못명으로 검색하여 일시키기");
			System.out.println("5. 개별 로봇이동");
			System.out.println("6. 로봇위치범위로 검색");
			System.out.println("7. 0.5초에 한번씩 100까지홀수 쓰레드로 찍기");
			System.out.println("8. 종료");
		}
		if(mode.compareTo("2")==0) {
		}
	}
	 void printMenu(int mode) {
		 printMenu(mode+"");
	 }
	
}

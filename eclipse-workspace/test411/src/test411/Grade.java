package test411;

import java.util.Scanner;

public class Grade {
	int math;
	int science;
	int english;
	
	public Grade(int math, int science, int english) {
		super();
		this.math = math;
		this.science = science;
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int average() {
		return (math+science+english)/3;
	}
	public void grade() {
		if(average()>=90) System.out.println("A");
		else if(average()>=80)  System.out.println("B");
		else if(average()>=80)  System.out.println("c");
		else if(average()>=80)  System.out.println("D");
		else System.out.println("F");
	}
	public static void main() {
		Scanner scan=new Scanner(System.in);
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math=scan.nextInt();
		int science =scan.nextInt();
		int english=scan.nextInt();
		Grade me=new Grade(math,science,english);
		System.out.println("평균은 "+me.average()) ;
	}

}

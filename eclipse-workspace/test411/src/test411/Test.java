package test411;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math=scan.nextInt();
		int science =scan.nextInt();
		int english=scan.nextInt();
		Grade me=new Grade(math,science,english);
		System.out.println("평균은 "+me.average()) ;
		me.grade();
		
		System.out.print("노래제목, 가수, 발표된 연도, 국적을 입력>>");
		String title=scan.next();
		String artist=scan.next();
		int year=scan.nextInt();
		String country=scan.next();
		Song s1=new Song(title,artist,year,country);
		System.out.print("노래제목, 가수, 발표된 연도, 국적을 입력>>");
		 title=scan.next();
		 artist=scan.next();
		 year=scan.nextInt();
		 country=scan.next();
		Song s2=new Song(title,artist,year,country);
		System.out.print("노래제목, 가수, 발표된 연도, 국적을 입력>>");
		 title=scan.next();
		 artist=scan.next();
		 year=scan.nextInt();
		 country=scan.next();
		Song s3=new Song(title,artist,year,country);
		s1.show();
		s2.show();
		s3.show();
		if(s1.compareArtist(s2))
			System.out.println(s1.getTitle()+"와(과)"+s2.getTitle()+"는 같은 아티스트 노래");
		else
			System.out.println(s1.getTitle()+"와(과)"+s2.getTitle()+"는 다른 아티스트 노래");
		if(s1.compareArtist(s3))
			System.out.println(s1.getTitle()+"와(과)"+s3.getTitle()+"는 같은 아티스트 노래");
		else
			System.out.println(s1.getTitle()+"와(과)"+s3.getTitle()+"는 다른 아티스트 노래");
		
	}
}

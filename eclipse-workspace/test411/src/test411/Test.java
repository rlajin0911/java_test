package test411;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("����, ����, ���� ������ 3���� ���� �Է�>>");
		int math=scan.nextInt();
		int science =scan.nextInt();
		int english=scan.nextInt();
		Grade me=new Grade(math,science,english);
		System.out.println("����� "+me.average()) ;
		me.grade();
		
		System.out.print("�뷡����, ����, ��ǥ�� ����, ������ �Է�>>");
		String title=scan.next();
		String artist=scan.next();
		int year=scan.nextInt();
		String country=scan.next();
		Song s1=new Song(title,artist,year,country);
		System.out.print("�뷡����, ����, ��ǥ�� ����, ������ �Է�>>");
		 title=scan.next();
		 artist=scan.next();
		 year=scan.nextInt();
		 country=scan.next();
		Song s2=new Song(title,artist,year,country);
		System.out.print("�뷡����, ����, ��ǥ�� ����, ������ �Է�>>");
		 title=scan.next();
		 artist=scan.next();
		 year=scan.nextInt();
		 country=scan.next();
		Song s3=new Song(title,artist,year,country);
		s1.show();
		s2.show();
		s3.show();
		if(s1.compareArtist(s2))
			System.out.println(s1.getTitle()+"��(��)"+s2.getTitle()+"�� ���� ��Ƽ��Ʈ �뷡");
		else
			System.out.println(s1.getTitle()+"��(��)"+s2.getTitle()+"�� �ٸ� ��Ƽ��Ʈ �뷡");
		if(s1.compareArtist(s3))
			System.out.println(s1.getTitle()+"��(��)"+s3.getTitle()+"�� ���� ��Ƽ��Ʈ �뷡");
		else
			System.out.println(s1.getTitle()+"��(��)"+s3.getTitle()+"�� �ٸ� ��Ƽ��Ʈ �뷡");
		
	}
}

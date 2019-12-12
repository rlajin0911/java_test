package B01;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Shared {
	ArrayList<LibaryBook> list =new ArrayList<LibaryBook>();
	Shared(){
		int sel=0;
		LoadFile(list);
		do {
			printMenu(1);
			sel=convStr(scanf());
			if(sel==-1) {
				System.out.println("잘못된 명령어 입니다.");
				continue;
			}
			switch(sel) {
			case 1:
				addData(list);
				break;
			case 2:
				printList(list,null,-1,-1);
				break;
			case 3:
				search(list);
				break;
			case 4:
				MM(list);
				break;
			case 5:
				setDVD(list);
				break;
			}
			SaveFile(list);
		}while(sel!=0);
	}
	void printMenu(String mode) {
		if(mode.compareTo("1")==0) {
			System.out.println("1. 책 데이터 입력");
			System.out.println("2. 도서 리스트 보기");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여 반납");
			System.out.println("5. DVD 정보 삭제 및 변경");
			System.out.println("6. 정렬보기");
			System.out.println("0. 종료");
		}else if(mode.compareTo("2")==0) {
			System.out.println("1. 제목으로 검색");
			System.out.println("2. 재고권수 범위로 검색");
		}else if(mode.compareTo("3")==0) {
			System.out.println("1. 도서 빌리기");
			System.out.println("2. 도서 반납");
		}else if(mode.compareTo("4")==0) {
			System.out.println("1. 변경");
			System.out.println("2. 삭제");
		}
	}
	void printMenu(int mode) {
		printMenu(mode+"");
	}
	String scanf() {
		Scanner in =new Scanner(System.in);
		System.out.print(">");
		String sel=in.nextLine();
		return sel;
	}
	int convStr(String data) {
		int a;
		try {
			a=Integer.parseInt(data);
		}catch(Exception e) {
			a=-1;
		}
		return a;
	}
	Boolean SaveFile(ArrayList<LibaryBook> list){
		try {
			DataOutputStream out = new DataOutputStream( new FileOutputStream("invoice1.txt") );
			for (LibaryBook book : list) {
				//System.out.println(j+"번째 입력 완료");
				
				//asdasd
				if(book instanceof Book) {
					Book temp=((Book)book);
					out.writeUTF("1");
					out.writeUTF(temp.getAuthor());
					out.writeUTF(temp.getPages()+"");
					out.writeUTF(temp.getPublisher());
					String line="";
					for(int i=0;i<temp.getRoles().length;i++) {
						line+=temp.getRoles()[i]+"/";
					}
					out.writeUTF(line);
				}else if(book instanceof DVD) {
					DVD temp=((DVD)book);
					out.writeUTF("2");
					out.writeUTF(temp.getDirector());
					out.writeUTF(temp.getNumOfDVD()+"");
					out.writeUTF(temp.getFilmStudio());
					String line="";
					for(int i=0;i<temp.getActors().length;i++) {
						line+=temp.getActors()[i]+"/";
					}
					out.writeUTF(line);
				}else if(book instanceof SongCD) {
					SongCD temp=((SongCD)book);
					out.writeUTF("3");
					out.writeUTF(temp.getSinger());
					out.writeUTF(temp.getNumOfCd()+"");
					out.writeUTF(temp.getProducer());
					String line="";
					for(int i=0;i<temp.getSongTitle().length;i++) {
						line+=temp.getSongTitle()[i]+"/";
					}
					out.writeUTF(line);
				}
				//asdasdasd
				out.writeUTF(book.getTitle());
				out.writeUTF(book.getShared()+"");
				out.writeUTF(book.getStore()+"");
				out.writeUTF(book.getPriceDollar()+"");
			}
			out.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		}catch(IOException e){
			//e.printStackTrace();
		}
		return true;
	}
	Boolean LoadFile(ArrayList<LibaryBook> list)  {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("invoice1.txt"));
			String []data=new String[9];
			while(true) {
				for(int i=0;i<9;i++) {
					data[i]=in.readUTF();
				}
				//asdasd
				if(Integer.parseInt(data[0])==1) {
					Book book=new Book(data[5], data[1], data[2], Integer.parseInt(data[7]), Integer.parseInt(data[2]));
					book.setRoles(data[4].split("/"));
					list.add(book);
				}
				if(Integer.parseInt(data[0])==2) {
					DVD book=new DVD(data[5], data[1], data[2], Integer.parseInt(data[7]), Integer.parseInt(data[2]));
					book.setActors(data[4].split("/"));
					list.add(book);
				}
				if(Integer.parseInt(data[0])==3) {
					SongCD book=new SongCD(data[5], data[1], data[2], Integer.parseInt(data[7]), Integer.parseInt(data[2]));
					book.setSongTitle(data[4].split("/"));
					list.add(book);
				}
			}
			//asdasd
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		}catch (IOException e) {
			//e.printStackTrace();
		}
		return true;
	}
	void addData(ArrayList<LibaryBook>list) {
		System.out.print("서적 종류");
		String type=scanf();
		if(type.compareTo("b")==0) {
			System.out.print("책제목,저자,출판사,재고권수,페이지수 ");String[] data=scanf().split(",");
			Book book=new Book(data[0],data[1],data[2],convStr(data[3]),convStr(data[4]));
			System.out.print("등장인물 리스트");data=scanf().split(" ");
			book.setRoles(data);
			list.add(book);
		}
		else if(type.compareTo("d")==0) {
			System.out.print("책제목,감독,영화사,재고권수,DVD숫자 ");String[] data=scanf().split(",");
			DVD dvd=new DVD(data[0],data[1],data[2],convStr(data[3]),convStr(data[4]));
			System.out.print("배우 리스트");data=scanf().split(" ");
			dvd.setActors(data);
			list.add(dvd);
		}
		else if(type.compareTo("s")==0) {
			System.out.print("책제목,가수,프로듀서,재고권수,CD숫자 ");String[] data=scanf().split(",");
			SongCD cd=new SongCD(data[0],data[1],data[2],convStr(data[3]),convStr(data[4]));
			System.out.print("노래목록");data=scanf().split(" ");
			cd.setSongTitle(data);
			list.add(cd);
		}
		SaveFile(list);
	}
	void printList(ArrayList<LibaryBook>list,String title,int min,int max) {
		int cnt=0;
		System.out.println("번호 책제목 형태 재고권수 대여권수 기타");
		for(Iterator<LibaryBook> itr = list.iterator(); itr.hasNext(); )
		{
			LibaryBook book=itr.next();
			if( (title!=null && (book.getTitle().compareTo(title)==0)) || 
					(min!=-1 && (book.getStore()<=max && book.getStore()>=min)) || 
					(title==null && min==-1) ) {
				cnt++;
				System.out.println(cnt+" "+book.toString());
			}
		}
	}
	void search(ArrayList<LibaryBook>list) {
		printMenu("2");String sel=scanf();
		if(sel.compareTo("1")==0) {
			System.out.print("제목입력");sel=scanf();
			printList(list,sel,-1,-1);
		}else if(sel.compareTo("2")==0) {
			System.out.print("범위 입력");
			String []dsel=scanf().split(" ");
			printList(list,null,convStr(dsel[0]),convStr(dsel[1]));
		}else {
			System.out.println("잘못된 선택입니다.");
		}
	}
	void MM(ArrayList<LibaryBook>list) {
		printList(list,null,-1,-1);
		printMenu(3);int sel = convStr(scanf());
		System.out.print("도서 ");
		if(sel==1) {
			System.out.print(" 빌릴 번호");
			sel = convStr(scanf());
			rent(list,sel);
		}else if(sel==2) {
			System.out.print(" 반납 번호");
			sel = convStr(scanf());
			retuin(list,sel);
		}
		printList(list,null,-1,-1);
	}
	void rent(ArrayList<LibaryBook>list,int sel) {
		if(sel!=-1 && list.size()>=sel) {
			System.out.print("빌릴 권수");
			int m = convStr(scanf());
			if(m!=-1) {
				sel--;
				if(list.get(sel).getShared()+m<=list.get(sel).getStore()) {
					list.get(sel).setShared(list.get(sel).getShared()+m);
					System.out.println("도서가 "+m+"개 대출되었습니다.");
				}else {
					System.out.println("도서가 모자랍니다.");
				}
			}
		}
	}
	void retuin(ArrayList<LibaryBook>list,int sel) {
		if(sel!=-1 && list.size()>=sel) {
			System.out.print("반납 권수");
			int m = convStr(scanf());
			if(m!=-1) {
				sel--;
				if(list.get(sel).getShared()-m>=0) {
					list.get(sel).setShared(list.get(sel).getShared()-m);
					System.out.println("도서가 "+m+"개 반납되었습니다.");
				}else {
					System.out.println("도서 개수가 잘못되었습니다.");
				}
			}
		}
	}
	void setDVD(ArrayList<LibaryBook>list) {
		try {
		System.out.println("도서 선택");int sel = convStr(scanf());
			if(sel!=-1 && list.size()>=sel) {
				int idx=sel-1;
				printMenu(4); sel= convStr(scanf());
				if(sel==1) {
					System.out.print("입력(dvd 제목, 감독, 영화사, dvd수)");String []data=scanf().split(",");
					System.out.print("입력(배우 리스트)");String d[]=scanf().split(" ");
					int temp=convStr(data[3]);
					if(temp!=-1) {
						((DVD)list.get(idx)).setAll(data[0], data[1], data[2], temp, d);
						System.out.println("수정되었습니다.");
					}
				}else if(sel==2){
					list.remove(idx);
					System.out.println("삭제되었습니다.");
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		Shared prog = new Shared();
	}
}
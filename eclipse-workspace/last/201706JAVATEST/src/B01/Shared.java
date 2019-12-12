package B01;
import java.util.*;
public class Shared {
	ArrayList<LibaryBook> list =new ArrayList<LibaryBook>();
	Shared(){
		int sel=0;
		LoadFile(list);
		do {
			printMenu(1);
			sel=convStr(scanf());
			if(sel==-1) {
				System.out.println("�߸��� ��ɾ� �Դϴ�.");
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
			System.out.println("1. å ������ �Է�");
			System.out.println("2. ���� ����Ʈ ����");
			System.out.println("3. ���� �˻�");
			System.out.println("4. ���� �뿩 �ݳ�");
			System.out.println("5. DVD ���� ���� �� ����");
			System.out.println("6. ���ĺ���");
			System.out.println("0. ����");
		}else if(mode.compareTo("2")==0) {
			System.out.println("1. �������� �˻�");
			System.out.println("2. ���Ǽ� ������ �˻�");
		}else if(mode.compareTo("3")==0) {
			System.out.println("1. ���� ������");
			System.out.println("2. ���� �ݳ�");
		}else if(mode.compareTo("4")==0) {
			System.out.println("1. ����");
			System.out.println("2. ����");
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
	Boolean SaveFile(ArrayList<LibaryBook> list) {
		return false;
	}
	Boolean LoadFile(ArrayList<LibaryBook> list) {
		return false;
	}
	void addData(ArrayList<LibaryBook>list) {
		System.out.print("���� ����");
		String type=scanf();
		if(type.compareTo("b")==0) {
			System.out.print("å����,����,���ǻ�,���Ǽ�,�������� ");String[] data=scanf().split(",");
			Book book=new Book(data[0],data[1],data[2],convStr(data[3]),convStr(data[4]));
			System.out.print("�����ι� ����Ʈ");data=scanf().split(" ");
			book.setRoles(data);
			list.add(book);
		}
		else if(type.compareTo("d")==0) {
			System.out.print("å����,����,��ȭ��,���Ǽ�,DVD���� ");String[] data=scanf().split(",");
			DVD dvd=new DVD(data[0],data[1],data[2],convStr(data[3]),convStr(data[4]));
			System.out.print("��� ����Ʈ");data=scanf().split(" ");
			dvd.setActors(data);
			list.add(dvd);
		}
		else if(type.compareTo("s")==0) {
			System.out.print("å����,����,���Ǽ�,CD���� ");String[] data=scanf().split(",");
			SongCD cd=new SongCD(data[0],data[1],data[2],convStr(data[3]),convStr(data[4]));
			System.out.print("�뷡���");data=scanf().split(" ");
			cd.setSongTitle(data);
			list.add(cd);
		}
		SaveFile(list);
	}
	void printList(ArrayList<LibaryBook>list,String title,int min,int max) {
		int cnt=0;
		System.out.println("��ȣ å���� ���� ���Ǽ� �뿩�Ǽ� ��Ÿ");
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
			System.out.print("�����Է�");sel=scanf();
			printList(list,sel,-1,-1);
		}else if(sel.compareTo("2")==0) {
			System.out.print("���� �Է�");
			String []dsel=scanf().split(" ");
			printList(list,null,convStr(dsel[0]),convStr(dsel[1]));
		}else {
			System.out.println("�߸��� �����Դϴ�.");
		}
	}
	void MM(ArrayList<LibaryBook>list) {
		printList(list,null,-1,-1);
		printMenu(3);int sel = convStr(scanf());
		System.out.print("���� ");
		if(sel==1) {
			System.out.print(" ���� ��ȣ");
			sel = convStr(scanf());
			rent(list,sel);
		}else if(sel==2) {
			System.out.print(" �ݳ� ��ȣ");
			sel = convStr(scanf());
			retuin(list,sel);
		}
		printList(list,null,-1,-1);
	}
	void rent(ArrayList<LibaryBook>list,int sel) {
		if(sel!=-1 && list.size()>=sel) {
			System.out.print("���� �Ǽ�");
			int m = convStr(scanf());
			if(m!=-1) {
				sel--;
				if(list.get(sel).getShared()+m<=list.get(sel).getStore()) {
					list.get(sel).setShared(list.get(sel).getShared()+m);
					System.out.println("������ "+m+"�� ����Ǿ����ϴ�.");
				}else {
					System.out.println("������ ���ڶ��ϴ�.");
				}
			}
		}
	}
	void retuin(ArrayList<LibaryBook>list,int sel) {
		if(sel!=-1 && list.size()>=sel) {
			System.out.print("�ݳ� �Ǽ�");
			int m = convStr(scanf());
			if(m!=-1) {
				sel--;
				if(list.get(sel).getShared()-m>=0) {
					list.get(sel).setShared(list.get(sel).getShared()-m);
					System.out.println("������ "+m+"�� �ݳ��Ǿ����ϴ�.");
				}else {
					System.out.println("���� ������ �߸��Ǿ����ϴ�.");
				}
			}
		}
	}
	void setDVD(ArrayList<LibaryBook>list) {
		System.out.println("���� ����");int sel = convStr(scanf());
		if(sel!=-1 && list.size()>=sel) {
			int idx=sel-1;
			printMenu(4); sel= convStr(scanf());
			if(sel==1) {
				System.out.print("�Է�(dvd ����, ����, ��ȭ��, dvd��)");String []data=scanf().split(",");
				System.out.print("�Է�(��� ����Ʈ)");String d[]=scanf().split(" ");
				int temp=convStr(data[3]);
				if(temp!=-1) {
					((DVD)list.get(idx)).setAll(data[0], data[1], data[2], temp, d);
					System.out.println("�����Ǿ����ϴ�.");
				}
			}else if(sel==2){
				list.remove(idx);
				System.out.println("�����Ǿ����ϴ�.");
			}
		}
	}
	public static void main(String[] args) {
		Shared prog = new Shared();
	}
}
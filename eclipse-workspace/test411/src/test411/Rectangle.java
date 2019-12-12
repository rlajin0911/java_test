package test411;

public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int heigth;
	
	public boolean contains(Rectangle r) {
		boolean result;
		if(x<=r.getX()
				&&y<=r.getY()
				&&(x+width)>=(r.getX()+r.getY())
				&&(y+heigth)>=(r.getX()+r.getY()) )
			return true;
		else 
			result=false;
		return result;
	}
	
	public int square() {
		return width*heigth;
	}
	
	public void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+heigth+" 인 사각형");
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	public Rectangle(int x, int y, int width, int heigth) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
	}
	public static void main() {
		Rectangle r =new Rectangle(2,2,8,7);
		Rectangle s = new Rectangle(5,5,6,6);
		Rectangle t = new Rectangle(1,1,10,10);
		
		r.show();
		System.out.println("s의 면적은"+s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
	}
}

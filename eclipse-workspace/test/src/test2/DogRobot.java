package test2;

public class DogRobot {
	private int x=150;
	private int y=150;
	private int barkPower=3;
	void barkStart() {
		System.out.println("barkPower"+barkPower+"으로 짖기를 시작하였습니다.");
	}
	void barkdown(){
		System.out.println("barkPower"+barkPower+"으로 짖다가 멈추였습니다.");
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
	public int getBarkPower() {
		return barkPower;
	}
	public void setBarkPower(int barkPower) {
		this.barkPower = barkPower;
	}
	public DogRobot(int x, int y, int barkPower) {
		super();
		this.x = x;
		this.y = y;
		this.barkPower = barkPower;
	}
	@Override
	public String toString() {
		return "DogRobot [x=" + x + ", y=" + y + ", barkPower=" + barkPower + "]";
	}
	
}

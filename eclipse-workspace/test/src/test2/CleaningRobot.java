package test2;

public class CleaningRobot extends Robot{
	private int x=30;
	private int y=30;
	private int disstance=3;
	private int cleaningPower=10;
	void cleaningStart() {
		System.out.println("cleaningPower"+cleaningPower+"���� û�Ҹ� �����Ͽ����ϴ�.");
	}
	void cleaningStop() {
		System.out.println("cleaningPower"+cleaningPower+"���� û�Ҹ� ���߿����ϴ�.");
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
	public int getDisstance() {
		return disstance;
	}
	public void setDisstance(int disstance) {
		this.disstance = disstance;
	}
	public int getCleaningPower() {
		return cleaningPower;
	}
	public void setCleaningPower(int cleaningPower) {
		this.cleaningPower = cleaningPower;
	}
	public CleaningRobot(int id, String robotname, int x, int y, int distance, int price, int x2, int y2, int disstance,
			int cleaningPower) {
		super(id, robotname, x, y, distance, price);
		x = x2;
		y = y2;
		this.disstance = disstance;
		this.cleaningPower = cleaningPower;
	}
	@Override
	public String toString() {
		return "CleaningRobot [x=" + x + ", y=" + y + ", disstance=" + disstance + ", cleaningPower=" + cleaningPower
				+ "]";
	}
	
}
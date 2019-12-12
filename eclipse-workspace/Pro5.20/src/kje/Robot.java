package kje;

public abstract class Robot {
	int id;
	String robotname;
	int x,y;
	int distance=5;
	int price;
	abstract int move(int direction);
	public Robot(int id, String robotname, int x, int y, int distance, int price) {
		super();
		this.id = id;
		this.robotname = robotname;
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRobotname() {
		return robotname;
	}
	public void setRobotname(String robotname) {
		this.robotname = robotname;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	};
}

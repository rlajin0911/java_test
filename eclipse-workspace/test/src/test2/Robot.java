package test2;

public abstract class Robot {
	private int id;
	private String robotname;
	private int x,y;
	private int distance;
	private int price;
	int move(int direction) {
		return 0;
	}
	@Override
	public String toString() {
		return "Robot [id=" + id + ", robotname=" + robotname + ", x=" + x + ", y=" + y + ", distance=" + distance
				+ ", price=" + price + "]";
	}
	
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
	}
}

package test426;

public class CPU extends Product{
	String speed;
	String inch;
	public CPU(String model, String company, int date, int numOfstock, int price, String speed, String inch) {
		super(model, company, date, numOfstock, price);
		this.speed = speed;
		this.inch = inch;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getInch() {
		return inch;
	}
	public void setInch(String inch) {
		this.inch = inch;
	}
}

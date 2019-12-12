package test426;

public class Refrigerator extends Product{
	String size;
	String type;
	public Refrigerator(String model, String company, int date, int numOfstock, int price, String size, String type) {
		super(model, company, date, numOfstock, price);
		this.size = size;
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

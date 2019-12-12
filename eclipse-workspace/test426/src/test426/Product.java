package test426;

public class Product {
	String model;
	String company;
	int date;
	int numOfstock;
	int price;
	public Product(String model, String company, int date, int numOfstock, int price) {
		super();
		this.model = model;
		this.company = company;
		this.date = date;
		this.numOfstock = numOfstock;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getNumOfstock() {
		return numOfstock;
	}
	public void setNumOfstock(int numOfstock) {
		this.numOfstock = numOfstock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

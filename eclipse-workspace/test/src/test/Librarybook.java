package test;

public abstract class Librarybook {
	private String title;
	private int store;
	private int rent;
	private double pricedollor;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public double getPricedollor() {
		return pricedollor;
	}
	public void setPricedollor(double pricedollor) {
		this.pricedollor = pricedollor;
	}
}

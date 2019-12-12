package B01;

public abstract class LibaryBook {
	private String title;
	private int store;
	private int shared;
	private double priceDollar;
	public LibaryBook(String title, int store, int shared, double priceDollar) {
		super();
		this.title = title;
		this.store = store;
		this.shared = shared;
		this.priceDollar = priceDollar;
	}
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
	public int getShared() {
		return shared;
	}
	public void setShared(int shared) {
		this.shared = shared;
	}
	public double getPriceDollar() {
		return priceDollar;
	}
	public void setPriceDollar(double priceDollar) {
		this.priceDollar = priceDollar;
	}
}

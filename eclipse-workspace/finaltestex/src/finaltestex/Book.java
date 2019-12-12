package finaltestex;

public class Book {
	String title,date;
	int price;
	String auther;
	int score;
	public Book(String title, String date, int price, String auther, int score) {
		super();
		this.title = title;
		this.date = date;
		this.price = price;
		this.auther = auther;
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}

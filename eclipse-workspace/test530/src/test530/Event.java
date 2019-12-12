package test530;

abstract public class Event {
	String title,date;
	int price,seat,ticketprice;
	
	public Event(String title, String date, int price, int seat, int ticketprice) {
		super();
		this.title = title;
		this.date = date;
		this.price = price;
		this.seat = seat;
		this.ticketprice = ticketprice;
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
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}
	
}

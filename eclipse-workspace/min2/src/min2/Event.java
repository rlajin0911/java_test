package min2;

abstract public class  Event {
	String title;
	int date;
	int ticketPrice;
	int numOfSeat;
	public Event(String title, int date, int ticketPrice, int numOfSeat) {
		super();
		this.title = title;
		this.date = date;
		this.ticketPrice = ticketPrice;
		this.numOfSeat = numOfSeat;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getNumOfSeat() {
		return numOfSeat;
	}
	public void setNumOfSeat(int numOfSeat) {
		this.numOfSeat = numOfSeat;
	}
}

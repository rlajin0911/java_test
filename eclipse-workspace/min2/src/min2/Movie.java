package min2;

public class Movie extends Event {
	String director;
	String actor;
	public Movie(String title, int date, int ticketprice, int numOfSeat, String director, String actor) {
		super(title, date, ticketprice, numOfSeat);
		this.director = director;
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
}

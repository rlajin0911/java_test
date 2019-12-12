package test530;

public class Movie extends Event{
	String director,actor;



	public Movie(String title, String date, int price, int seat, int ticketprice, String director, String actor) {
		super(title, date, price, seat, ticketprice);
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

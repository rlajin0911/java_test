package min2;

public class Musical extends Event{
	String actorname;
	int actornum;
	public Musical(String title, int date, int ticketprice, int numOfSeat, String actorname, int actornum) {
		super(title, date, ticketprice, numOfSeat);
		this.actorname = actorname;
		this.actornum = actornum;
	}
	public String getActorname() {
		return actorname;
	}
	public void setActorname(String actorname) {
		this.actorname = actorname;
	}
	public int getActornum() {
		return actornum;
	}
	public void setActornum(int actornum) {
		this.actornum = actornum;
	}
	
}

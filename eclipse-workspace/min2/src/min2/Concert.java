package min2;

public class Concert extends Event{
	String singer;
	String stageManager;
	public Concert(String title, int date, int ticketprice, int numOfSeat, String singer, String stageManager) {
		super(title, date, ticketprice, numOfSeat);
		this.singer = singer;
		this.stageManager = stageManager;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getStageManager() {
		return stageManager;
	}
	public void setStageManager(String stageManager) {
		this.stageManager = stageManager;
	}
	
}

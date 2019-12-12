package test;

public class SongCD extends Librarybook {
	private String singer;
	private String[] songTitle=new String[3];
	private String producer;
	private int num;
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String[] getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String[] songTitle) {
		this.songTitle = songTitle;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}

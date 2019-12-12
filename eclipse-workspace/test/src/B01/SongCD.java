package B01;

import java.util.Arrays;

public class SongCD extends LibaryBook{
	private String singer;
	private String[] songTitle;
	private String producer;
	private int numOfCd;
	public SongCD(String title, String singer, String producer,int store, int numOfCd) {
		super(title, store, 0, 0);
		this.singer = singer;
		this.producer = producer;
		this.numOfCd = numOfCd;
	}
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
	public int getNumOfCd() {
		return numOfCd;
	}
	public void setNumOfCd(int numOfCd) {
		this.numOfCd = numOfCd;
	}
	@Override
	public String toString() {
		return getTitle()+" Book "+getStore()+" "+getShared()+" producer="+getProducer()+" songTitle="+Arrays.toString(getSongTitle());
	}	
}

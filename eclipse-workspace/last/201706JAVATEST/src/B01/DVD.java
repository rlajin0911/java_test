package B01;

import java.util.Arrays;

public class DVD extends LibaryBook{
	String director;
	String[] actors;
	String filmStudio;
	int numOfDVD;
	public DVD(String title, String director, String filmStudio,int store, int numOfDVD) {
		super(title, store, 0, 0);
		this.director = director;
		this.filmStudio = filmStudio;
		this.numOfDVD = numOfDVD;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public String getFilmStudio() {
		return filmStudio;
	}
	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	public int getNumOfDVD() {
		return numOfDVD;
	}
	public void setNumOfDVD(int numOfDVD) {
		this.numOfDVD = numOfDVD;
	}
	@Override
	public String toString() {
		return getTitle()+" Book "+getStore()+" "+getShared()+" filmStudio="+getFilmStudio()+" actors="+Arrays.toString(getActors());
	}
	public void setAll(String title, String director, String filmStudio,int numOfDVD,String[] actors) {
		this.director = director;
		this.filmStudio = filmStudio;
		this.numOfDVD = numOfDVD;
		this.setTitle(title);
		this.actors=actors;
	}
}

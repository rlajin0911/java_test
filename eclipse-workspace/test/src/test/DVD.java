package test;

public class DVD extends Librarybook{
	private String director;
	private String[] actor=new String[3];
	private String filmStudio;
	private int num;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String[] getActor() {
		return actor;
	}
	public void setActor(String[] actor) {
		this.actor = actor;
	}
	public String getFilmStudio() {
		return filmStudio;
	}
	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}

package B01;

import java.util.Arrays;

public class Book extends LibaryBook{
	private String author;
	private String[]roles;
	private String publisher;
	private int pages;
	public Book(String title, String author, String publisher, int store, int pages) {
		super(title, store, 0, 0);
		this.author = author;
		this.publisher = publisher;
		this.pages = pages;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return getTitle()+" Book "+getStore()+" "+getShared()+" publisher="+getPublisher()+" roles="+Arrays.toString(getRoles());
	}	
}

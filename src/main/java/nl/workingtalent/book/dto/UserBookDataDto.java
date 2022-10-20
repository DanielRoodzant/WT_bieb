package nl.workingtalent.book.dto;

import java.time.LocalDate;

public class UserBookDataDto {

	private String title;
	
	private String Author;
	
	private LocalDate date;
	
	// Getters & setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return Author;
	}
	
	public void setAuthor(String author) {
		Author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}

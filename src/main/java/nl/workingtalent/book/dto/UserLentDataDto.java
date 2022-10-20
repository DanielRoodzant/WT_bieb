package nl.workingtalent.book.dto;

import java.time.LocalDateTime;

public class UserLentDataDto {

	private String title;
	
	private LocalDateTime date;
	
	// Getters & setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}

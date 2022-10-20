package nl.workingtalent.book.dto;

import java.time.LocalDate;

public class UserReservationDataDto {
	
	private String title;
	
	private LocalDate date;
	
	// Getters & setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}

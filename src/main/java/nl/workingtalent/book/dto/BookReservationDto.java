package nl.workingtalent.book.dto;

import java.time.LocalDate;

public class BookReservationDto {

	
	// Properties
	
	
	public String firstName;
	
	public String lastName;
	
	public LocalDate date;


	
	// Getters and Setters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}

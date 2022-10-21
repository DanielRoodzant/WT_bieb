package nl.workingtalent.book;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	
	private LocalDate date;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private User user;

	@JsonIgnore
	@ManyToOne(optional = false)
	private Book book;
	
	@OneToOne(optional = true, mappedBy = "reservation")
	private Lent lent;
	
	// Getters & setters
	
	public int getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Lent getLent() {
		return lent;
	}

	public void setLent(Lent lent) {
		this.lent = lent;
	}

	
}

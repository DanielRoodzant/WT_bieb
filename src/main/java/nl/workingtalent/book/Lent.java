package nl.workingtalent.book;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lent {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int lentId;

	@Column(length = 10, nullable = false)
	private LocalDateTime lentDateTime;

	
	// Relations
	
	@JsonIgnore
	@OneToOne(optional = false)
	private Reservation reservation;
	
	@OneToOne(optional = true, mappedBy = "lent")
	private Returned returned;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private Copy copy;


	// Getters & setters

	public int getLentId() {
		return lentId;
	}

	public void setLentId(int lentId) {
		this.lentId = lentId;
	}

	public LocalDateTime getLentDateTime() {
		return lentDateTime;
	}

	public void setLentDateTime(LocalDateTime lentDateTime) {
		this.lentDateTime = lentDateTime;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Returned getReturned() {
		return returned;
	}

	public void setReturned(Returned returned) {
		this.returned = returned;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}
	
}

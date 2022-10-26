package nl.workingtalent.book;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Returned {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int returnedId;

	@Column(length = 10, nullable = false)
	private LocalDate returnedDate;

	// Relations

	@JsonIgnore
	@OneToOne(optional = false)
	private Lent lent;

	// Getters and setters 
	
	public int getReturnedId() {
		return returnedId;
	}

	public void setReturnedId(int returnedId) {
		this.returnedId = returnedId;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

	public Lent getLent() {
		return lent;
	}

	public void setLent(Lent lent) {
		this.lent = lent;
	}

}
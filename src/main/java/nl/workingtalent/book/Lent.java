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

	
	// Relation
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private User user;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private Copy copy;

	@OneToOne(optional = true, mappedBy = "lent")
	private Returned returned;
	
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

}

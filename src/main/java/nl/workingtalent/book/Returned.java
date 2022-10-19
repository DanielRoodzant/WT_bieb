package nl.workingtalent.book;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Returned {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int returnedId;

	@Column(length = 10, nullable = false)
	private LocalDateTime returnedDateTime;

	private boolean archived;

	// Relations
	
	@OneToOne(optional = false)
	private Lent lent;

	// Getters and setters 
	
	public int getReturnedId() {
		return returnedId;
	}

	public void setReturnedId(int returnedId) {
		this.returnedId = returnedId;
	}

	public LocalDateTime getReturnedDateTime() {
		return returnedDateTime;
	}

	public void setReturnedDateTime(LocalDateTime returnedDateTime) {
		this.returnedDateTime = returnedDateTime;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public Lent getLent() {
		return lent;
	}

	public void setLent(Lent lent) {
		this.lent = lent;
	}

}
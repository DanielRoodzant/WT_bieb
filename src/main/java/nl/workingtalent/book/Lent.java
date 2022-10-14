package nl.workingtalent.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lent {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int lentId;
	
	@Column(name = "user_id", length = 6, nullable = false)
	private int userId;
	
	@Column(length = 10, nullable = false)
	private String date;
	//checken: date is string?
		
	@Column(name = "copy_id", nullable = false)
	private int copyId;

	// Getters & setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLentIdcopy() {
		return copyId;
	}

	public void setLentIdcopy(int copyId) {
		this.copyId = copyId;
	}

	//getters en setters
	public int getLentId() {
		return lentId;
	}

	public void setLentId(int lentId) {
		this.lentId = lentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

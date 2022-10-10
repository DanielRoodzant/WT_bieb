package nl.workingtalent.book;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Returned {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int returnedId;
	
	@Column (length = 10, nullable = false)
	private String date;
	//checken: date is string?
	
	private boolean archived;


	//one-to-many: userId(1) en copyId(2)
	@ManyToMany(cascade = CascadeType.REMOVE)
	private List<User> user;	
	
	public List<User> user() {
		return user;
	}

	public void setBookLabels(List<User> user) {
		this.user = user;
	}
	//copyId(2)--> nog toevoegen
	//@ManyToMany(cascade = CascadeType.REMOVE)
	//private List<User> user;	
	//
	//public List<User> user() {
	//	return user;
	//}
	//
	//public void setBookLabels(List<User> user) {
	//	this.user = user;
	//}
	
	//getters en setters
	public int getReturnedId() {
		return returnedId;
	}

	public void setReturnedId(int returnedId) {
		this.returnedId = returnedId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}
		
}
package nl.workingtalent.book;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Lent {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int lentId;
	
	@Column (length = 10, nullable = false)
	private String date;
	//checken: date is string?
	
	private boolean archived;

	//one-to-many
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Copy.class)
	@JoinColumn(name = "book_copy_id")
	private List<Copy> copyIdList;
	
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

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}
		
}

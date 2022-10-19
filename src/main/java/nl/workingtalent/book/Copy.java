package nl.workingtalent.book;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Copy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int copyId;

	@Column(nullable = false)
	private int copyNr;

	
	// Relations

	@ManyToOne(optional = false)
	private Book book;
	
	@OneToMany(mappedBy = "copy")
	private List<Lent> lents;

	
	// getters & setters

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public int getCopyNr() {
		return copyNr;
	}

	public void setCopyNr(int copyNr) {
		this.copyNr = copyNr;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Lent> getLents() {
		return lents;
	}

	public void setLents(List<Lent> lents) {
		this.lents = lents;
	}


}

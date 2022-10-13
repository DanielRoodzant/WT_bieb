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
public class BookLabel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookLabelId;
	
	@Column(length = 200, nullable = false)
	private String name;
	
	// Many-to-many connection
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "bookLabels")
	private List<Book> books;
	
	// Getters & setters (methods)
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getBookLabelId() {
		return bookLabelId;
	}

	public void setBookLabelId(int bookLabelId) {
		this.bookLabelId = bookLabelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	
	
	
}

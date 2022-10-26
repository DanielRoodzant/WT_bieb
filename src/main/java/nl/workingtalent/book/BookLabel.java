package nl.workingtalent.book;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BookLabel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookLabelId;

	@Column(length = 200, nullable = false)
	private String name;

	
	// Relations
	
	@JsonIgnore
	@ManyToMany()
	private List<Book> books;

	
	// Getters and Setters
	
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}

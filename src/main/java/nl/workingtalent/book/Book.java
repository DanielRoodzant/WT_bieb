package nl.workingtalent.book;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@Column (length = 200, nullable = false)
	private String title;
	
	@Column (length = 200, nullable = false)
	private String author;
	
	@Column (length = 200, nullable = false)
	private int isbn;
	
	private boolean archived;

	
	// Relations 
	
	@ManyToMany(mappedBy = "books")
	private List<BookLabel> bookLabels;	

	@JsonIgnore
	@OneToMany(mappedBy = "book")
	private List<Reservation> reservations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "book")
	private List<Copy> copies;

	
	// Getters & setters 
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public List<BookLabel> getBookLabels() {
		return bookLabels;
	}

	public void setBookLabels(List<BookLabel> bookLabels) {
		this.bookLabels = bookLabels;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Copy> getCopies() {
		return copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}
	
}

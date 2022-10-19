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
public class Book {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private List<Reservation> bookIdList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_copy_id")
	private List<Copy> copyIdList;
	
	
	@Column (length = 200, nullable = false)
	private String title;
	
	@Column (length = 200, nullable = false)
	private String author;
	
	@Column (length = 200, nullable = false)
	private int isbn;
	
	private boolean archived;

	// Many-to-many connection
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<BookLabel> bookLabels;	
	
	// Getters & setters
	public List<BookLabel> getBookLabels() {
		return bookLabels;
	}

	public void setBookLabels(List<BookLabel> bookLabels) {
		this.bookLabels = bookLabels;
	}

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
	
	

	
}

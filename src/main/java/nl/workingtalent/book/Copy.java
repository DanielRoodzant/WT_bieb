package nl.workingtalent.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Copy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int copyId;
	
	@Column(name = "book_copy_id")
	private int bookCopyId;
	
	@Column(nullable = false)
	private int copyNr;

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public int getBookCopyId() {
		return bookCopyId;
	}

	public void setBookCopyId(int bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public int getCopyNr() {
		return copyNr;
	}

	public void setCopyNr(int copyNr) {
		this.copyNr = copyNr;
	}
	
	

}

package nl.workingtalent.book.dto;

public class BookCopyDto {

	// Properties
	
	private String title;
	
	private String author;
	
	private int copyNr;



	
	// Getters and Setters
	
	public String getBookTitle() {
		return title;
	}

	public void setBookTitle(String bookTitle) {
		this.title = bookTitle;
	}

	public String getBookAuthor() {
		return author;
	}

	public void setBookAuthor(String bookAuthor) {
		this.author = bookAuthor;
	}

	public int getCopyNr() {
		return copyNr;
	}

	public void setCopyNr(int copyNr) {
		this.copyNr = copyNr;
	}
	
	
}

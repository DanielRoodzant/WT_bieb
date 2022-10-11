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
	

}

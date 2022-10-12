package nl.workingtalent.book;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Copy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int copyId;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Lent.class)
	@JoinColumn(name = "lentId")
	private List<Lent> lentIdList;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Returned.class)
	@JoinColumn(name = "returnedId")
	private List<Returned> returnedIdList;
	
	@Column(name = "book_copy_id")
	private int bookCopyId;
	
	@Column(nullable = false)
	private int copyNr;
	
	

}

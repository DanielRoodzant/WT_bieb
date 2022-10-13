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
	@JoinColumn(name = "copy_id")
	private List<Lent> lentIdList;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Returned.class)
	@JoinColumn(name = "returnedId")
	private List<Returned> returnedIdList;
	
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

	public List<Lent> getLentIdList() {
		return lentIdList;
	}

	public void setLentIdList(List<Lent> lentIdList) {
		this.lentIdList = lentIdList;
	}

	public List<Returned> getReturnedIdList() {
		return returnedIdList;
	}

	public void setReturnedIdList(List<Returned> returnedIdList) {
		this.returnedIdList = returnedIdList;
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

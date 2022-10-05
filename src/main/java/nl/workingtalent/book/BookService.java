package nl.workingtalent.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public Book registerBook(Book book) {
		return repo.save(book);
	}

}

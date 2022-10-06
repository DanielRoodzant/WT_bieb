package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Book> printBookList(){
		return repo.findAll();
	}
	
	public Optional<Book> findById(Integer id){
		return repo.findById(id);
	}
	
	public Book registerBook(Book book) {
		return repo.save(book);
	}
	
	public void bookDelete(Book book) {
        repo.delete(book);
    }

}

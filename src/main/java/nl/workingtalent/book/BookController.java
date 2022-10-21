package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.book.dto.SearchBookDto;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookController {

	@Autowired
	private BookService Service;
	
	@RequestMapping(value="book")
	public List<Book> demo() {
		return Service.printBookList();
	}
	
	@RequestMapping(value="book/register", method = RequestMethod.POST)
	public Book register(@RequestBody Book book) {
		return Service.registerBook(book);
	}
	
	@RequestMapping(value="book/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer id, @RequestBody Book book) {
		Optional<Book> optional = Service.findById(id);
		Book p = optional.get();
		
		if(book.getTitle().length() > 0) {
			p.setTitle(book.getTitle());
		}
		if(book.getAuthor().length() > 0) {
			p.setAuthor(book.getAuthor());
		}
		if(book.getIsbn() > 0) {
			p.setIsbn(book.getIsbn());
		}
		
		Service.registerBook(p);
	}
	
	@RequestMapping(value="book/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Book> book = Service.findById(id);
        Service.bookDelete(book.get());
    }
	
	@RequestMapping(value="book/archive/{id}", method = RequestMethod.PUT)
	public void archive(@PathVariable Integer id) {
		Optional<Book> optional = Service.findById(id);
		Book p = optional.get();
		
		if(p.isArchived() == false) {
			p.setArchived(true);
		}else {
			p.setArchived(false);
		}
		Service.registerBook(p);
	}
	
	@RequestMapping(value="book/addLabel/{id}", method = RequestMethod.PUT)
	public void addLabel(@PathVariable Integer id, @RequestBody Book book) {
		Optional<Book> optional = Service.findById(id);
		Book p = optional.get();
		
		p.setBookLabels(book.getBookLabels());
		
		Service.registerBook(p);
	}
	
	// boeken zoekfunctie
	@RequestMapping(value="book/{id}")    
	public Optional<Book> findBook(@PathVariable Integer id) {        
		return Service.findById(id);    
		}
	    

	@PostMapping("book/search")
	public List<Book> search(@RequestBody SearchBookDto dto) {
		return Service.search(dto.getZoekterm());
	}

}

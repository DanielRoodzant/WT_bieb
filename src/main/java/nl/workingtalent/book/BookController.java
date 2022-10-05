package nl.workingtalent.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookController {

	@Autowired
	private BookService Service;
	
	@RequestMapping(value="book/register", method = RequestMethod.POST)
	public Book register(@RequestBody Book book) {
		return Service.registerBook(book);
	}
	
}

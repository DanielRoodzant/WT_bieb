package nl.workingtalent.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.book.dto.BookCopyDto;

@RestController
@CrossOrigin (maxAge = 3600)
public class CopyController {

	@Autowired
	private CopyService Service;
	
	@Autowired
	private BookService BookService;
	
	
	@RequestMapping(value = "copy")
	public List<Copy> copyDemo() {
		return Service.printCopyList();
	}
	
	@RequestMapping(value="copy/register", method = RequestMethod.POST)
	public Copy register(@RequestBody Copy copy) {
		return Service.registerCopy(copy);
	
	}
	
	@RequestMapping(value="copy/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Copy> copy = Service.findById(id);
        Service.copyDelete(copy.get());
    }
	
	@GetMapping("copy/book/{id}")
    public List<BookCopyDto> BookCopies(@PathVariable Integer id) {
		Optional<Book> optionalBook = BookService.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
				
	        List<Copy> copies = book.getCopies();
	
	        List<BookCopyDto> result = new ArrayList<>();
	        for (Copy c : copies) {
	        	BookCopyDto dto = new BookCopyDto();
	            dto.setBookTitle(c.getBook().getTitle());
	            dto.setBookAuthor(c.getBook().getAuthor());
	            dto.setCopyNr(c.getCopyNr());
	            
	            result.add(dto);
	        }
        
	        return result;
		}
		
		return null;
    }
	
}

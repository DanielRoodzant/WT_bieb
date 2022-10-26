package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class BookLabelController {

	@Autowired
	private BookLabelService Service;
	
	@RequestMapping(value="bookLabel")
	public List<BookLabel> demo() {
		return Service.printBookLabelList();
	}
	
	@RequestMapping(value="bookLabel/register", method = RequestMethod.POST)
	public BookLabel register(@RequestBody BookLabel bookLabel) {
		return Service.registerBookLabel(bookLabel);
	}
	
	@RequestMapping(value="bookLabel/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer id, @RequestBody BookLabel bookLabel) {
		Optional<BookLabel> optional = Service.findById(id);
		BookLabel p = optional.get();
		
		if(bookLabel.getName().length() > 0) {
			p.setName(bookLabel.getName());
		}
		
		Service.registerBookLabel(p);
	}
	
	@RequestMapping(value="bookLabel/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<BookLabel> bookLabel = Service.findById(id);
        Service.bookLabelDelete(bookLabel.get());
    }
	
}

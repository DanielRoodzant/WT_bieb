package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLabelService {
	
	@Autowired
	private BookLabelRepository repo;
	
	public List<BookLabel> printBookLabelList(){
		return repo.findAll();
	}
	
	public Optional<BookLabel> findById(Integer id){
		return repo.findById(id);
	}
	
	public BookLabel registerBookLabel(BookLabel bookLabel) {
		return repo.save(bookLabel);
	}
	
	public void bookLabelDelete(BookLabel bookLabel) {
        repo.delete(bookLabel);
    }

}

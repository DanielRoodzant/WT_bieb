package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnedService {
	
	@Autowired
	private ReturnedRepository repo;
	
	public List<Returned> printReturnedList(){
		return repo.findAll();
	}
	
	public Optional<Returned> findById(Integer id){
		return repo.findById(id);
	}
	
	public Returned registerReturned(Returned returned) {
		return repo.save(returned);
	}
	
	public void returnedDelete(Returned returned) {
        repo.delete(returned);
    }

}
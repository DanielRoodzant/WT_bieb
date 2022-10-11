package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopyService {

	@Autowired
	private CopyRepository repo;
	
	public List<Copy> printCopyList(){
		return repo.findAll();
	}
	
	public Optional<Copy> findById(Integer id){
		return repo.findById(id);
	}
	
	public Copy registerCopy(Copy copy) {
		return repo.save(copy);
	}
	
	public void copyDelete(Copy copy) {
        repo.delete(copy);
    }
	
	
	
}

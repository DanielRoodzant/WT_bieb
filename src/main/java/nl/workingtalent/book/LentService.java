package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LentService {
	
	@Autowired
	private LentRepository repo;
	
	public List<Lent> printLentList(){
		return repo.findAll();
	}
	
	public Optional<Lent> findById(Integer id){
		return repo.findById(id);
	}
	
	public List<Lent> findByUser(Integer id){
		return repo.findByUserId(id);
	}
	
	public Lent registerLent(Lent lent) {
		return repo.save(lent);
	}
	
	public void lentDelete(Lent lent) {
        repo.delete(lent);
    }

}
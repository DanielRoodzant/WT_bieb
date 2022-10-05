package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> printUserList(){
		return repo.findAll();
	}
	
	public Optional<User> findById(Integer id){
		return repo.findById(id);
	}
	
	public User registerUser(User user) {
		return repo.save(user);
	}
	
	
	public void userDelete(User user) {
        repo.delete(user);
    }
	
	
}

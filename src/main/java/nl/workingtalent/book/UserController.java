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
public class UserController {
	
	@Autowired
	private UserService Service;
	
	@RequestMapping(value="user")
	public List<User> demo() {
		return Service.printUserList();
	}
	
	@RequestMapping(value="user/register", method = RequestMethod.POST)
	public User register(@RequestBody User user) {
		return Service.registerUser(user);
	}
	
	@RequestMapping(value="user/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer id, @RequestBody User user) {
		Optional<User> optional = Service.findById(id);
		User p = optional.get();
		
		if(user.getFirstName().length() > 0){
			p.setFirstName(user.getFirstName());
		}
		if(user.getLastName().length() > 0){
			p.setLastName(user.getLastName());
		}
		if(user.getPassword().length() > 0){
			p.setPassword(user.getPassword());
		}
		if(user.getEmail().length() > 0) {
			p.setEmail(user.getEmail());
		}
		
		Service.registerUser(p);
	}
	
	@RequestMapping(value="user/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<User> user = Service.findById(id);
        Service.userDelete(user.get());
    }
}

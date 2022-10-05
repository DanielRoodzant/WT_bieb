package nl.workingtalent.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserService Service;
	
	@RequestMapping(value="register", method = RequestMethod.POST)
	public User register(@RequestBody User user) {
		return Service.registerUser(user);
	}
}

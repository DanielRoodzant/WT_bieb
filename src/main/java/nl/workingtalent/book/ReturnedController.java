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

import nl.workingtalent.book.dto.UserBookDataDto;

@RestController
@CrossOrigin(maxAge = 3600)
public class ReturnedController {

	@Autowired
	private ReturnedService Service;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="returned")
	public List<Returned> demo() {
		return Service.printReturnedList();
	}
	
	@RequestMapping(value="Returned/register", method = RequestMethod.POST)
	public Returned register(@RequestBody Returned returned) {
		return Service.registerReturned(returned);
	}
	
	@RequestMapping(value="returned/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer id, @RequestBody Returned returned) {
		Optional<Returned> optional = Service.findById(id);
		Returned p = optional.get();

		if(returned.getReturnedDate() != null) {
			p.setReturnedDate(returned.getReturnedDate());
		}
		
		Service.registerReturned(p);
	}
	
	@RequestMapping(value="returned/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Returned> returned = Service.findById(id);
        Service.returnedDelete(returned.get());
    }
	
	@GetMapping(value="returned/user/{id}")
	public List<UserBookDataDto> returnedData(@PathVariable Integer id) {
		Optional<User> optionalUser = userService.findById(id);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
				
	        List<Reservation> reservations = user.getReservations();
	        
	        List<UserBookDataDto> result = new ArrayList<>();
	        for (Reservation r : reservations) {
	        	if(r.getLent() != null && r.getLent().getReturned() != null) {
		         	UserBookDataDto dto = new UserBookDataDto();
			        dto.setTitle(r.getBook().getTitle());
			        dto.setAuthor(r.getBook().getAuthor());
		            dto.setDate(r.getLent().getReturned().getReturnedDate());
			            
			        result.add(dto);
	        	}else {
	        		
		        	continue;
	        	}
	        }
	        
	        return result;
		}
		
		return null;
    }
}
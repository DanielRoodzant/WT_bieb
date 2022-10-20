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

import nl.workingtalent.book.dto.UserLentDataDto;

@RestController
@CrossOrigin(maxAge = 3600)
public class LentController {

	@Autowired
	private LentService Service;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="lent")
	public List<Lent> demo() {
		return Service.printLentList();
	}
	
	@GetMapping(value="lent/user/{id}")
	public List<UserLentDataDto> lentData(@PathVariable Integer id) {
		Optional<User> optionalUser = userService.findById(id);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
				
	        List<Reservation> reservations = user.getReservations();
	        List<Lent> lents = new ArrayList<>();
	        for (Reservation r : reservations) {
	        	Lent lent = r.getLent();
	        	
	        	lents.add(lent);
	        }
	
	        List<UserLentDataDto> result = new ArrayList<>();
	        for (Lent l : lents) {
	        	UserLentDataDto dto = new UserLentDataDto();
	            dto.setTitle(l.getReservation().getBook().getTitle());
	            dto.setDate(l.getLentDateTime());
	            
	            result.add(dto);
	        }
        
	        return result;
		}
		
		return null;
    }
	
	@RequestMapping(value="Lent/register", method = RequestMethod.POST)
	public Lent register(@RequestBody Lent lent) {
		return Service.registerLent(lent);
	}
	
	@RequestMapping(value="lent/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer id, @RequestBody Lent lent) {
		Optional<Lent> optional = Service.findById(id);
		Lent p = optional.get();

		if(lent.getLentDateTime() != null) {
			p.setLentDateTime(lent.getLentDateTime());
		}
	
		
		Service.registerLent(p);
	}
	
	@RequestMapping(value="lent/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Lent> lent = Service.findById(id);
        Service.lentDelete(lent.get());
    }

}
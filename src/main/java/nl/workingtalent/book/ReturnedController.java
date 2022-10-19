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
public class ReturnedController {

	@Autowired
	private ReturnedService Service;
	
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

		if(returned.getReturnedDateTime() != null) {
			p.setReturnedDateTime(returned.getReturnedDateTime());
		}
		
		Service.registerReturned(p);
	}
	
	@RequestMapping(value="returned/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Returned> returned = Service.findById(id);
        Service.returnedDelete(returned.get());
    }
	
	@RequestMapping(value="returned/archive/{id}", method = RequestMethod.PUT)
	public void archive(@PathVariable Integer id) {
		Optional<Returned> optional = Service.findById(id);
		Returned p = optional.get();
		
		if(p.isArchived() == false) {
			p.setArchived(true);
		}else {
			p.setArchived(false);
		}
		Service.registerReturned(p);
	}
}
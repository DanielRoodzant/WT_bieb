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
public class LentController {

	@Autowired
	private LentService Service;
	
	@RequestMapping(value="lent")
	public List<Lent> demo() {
		return Service.printLentList();
	}
	
	@RequestMapping(value="Lent/register", method = RequestMethod.POST)
	public Lent register(@RequestBody Lent lent) {
		return Service.registerLent(lent);
	}
	
	@RequestMapping(value="lent/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer id, @RequestBody Lent lent) {
		Optional<Lent> optional = Service.findById(id);
		Lent p = optional.get();
		
		if(lent.getDate().length() > 0) {
			p.setDate(lent.getDate());
		}
	
		
		Service.registerLent(p);
	}
	
	@RequestMapping(value="lent/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Lent> lent = Service.findById(id);
        Service.lentDelete(lent.get());
    }
	
	@RequestMapping(value="lent/archive/{id}", method = RequestMethod.PUT)
	public void archive(@PathVariable Integer id) {
		Optional<Lent> optional = Service.findById(id);
		Lent p = optional.get();
		
		if(p.isArchived() == false) {
			p.setArchived(true);
		}else {
			p.setArchived(false);
		}
		Service.registerLent(p);
	}
}
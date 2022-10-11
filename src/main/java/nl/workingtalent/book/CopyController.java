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
@CrossOrigin (maxAge = 3600)
public class CopyController {

	@Autowired
	private CopyService Service;
	
	@RequestMapping(value = "copy")
	public List<Copy> copyDemo() {
		return Service.printCopyList();
	}
	
	@RequestMapping(value="copy/register", method = RequestMethod.POST)
	public Copy register(@RequestBody Copy copy) {
		return Service.registerCopy(copy);
	
	}
	
	@RequestMapping(value="copy/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Copy> copy = Service.findById(id);
        Service.copyDelete(copy.get());
    }
	
	
	
}

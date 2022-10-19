package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.book.dto.ReserveBookDto;

@RestController
@CrossOrigin (maxAge = 3600)
public class ReservationController {

	@Autowired
	private ReservationService ReservationService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "reservation")
	public List<Reservation> reservationDemo() {
		return ReservationService.printReservationList();
	}
	
	@RequestMapping(value="reservation/register", method = RequestMethod.POST)
	public void register(@RequestBody ReserveBookDto dto) {
		Optional<User> userOptional = userService.findById(dto.getUserId());
		Optional<Book> bookOptional = bookService.findById(dto.getBookId()); 
		if (userOptional.isPresent() && bookOptional.isPresent()) {
			Reservation r = new Reservation();
			r.setUser(userOptional.get());
			r.setBook(bookOptional.get());
		}
	}
	
	@RequestMapping(value="reservation/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Reservation> reservation = ReservationService.findById(id);
        ReservationService.reservationDelete(reservation.get());
    }
	
	
}

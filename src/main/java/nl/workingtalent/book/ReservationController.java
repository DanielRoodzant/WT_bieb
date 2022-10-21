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

import nl.workingtalent.book.dto.ReserveBookDto;
import nl.workingtalent.book.dto.UserBookDataDto;

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
	
	@GetMapping("reservation/user/{id}")
    public List<UserBookDataDto> reservationData(@PathVariable Integer id) {
		Optional<User> optionalUser = userService.findById(id);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
				
	        List<Reservation> reservations = user.getReservations();
	
	        List<UserBookDataDto> result = new ArrayList<>();
	        for (Reservation r : reservations) {
	        	if(r.getLent() == null) {
		        	UserBookDataDto dto = new UserBookDataDto();
		            dto.setTitle(r.getBook().getTitle());
		            dto.setAuthor(r.getBook().getAuthor());
		            dto.setDate(r.getDate());
		            
		            result.add(dto);
	        	}else {
	        		
	        		continue;
	        	}
	        }
    
	        return result;
		}
		
		return null;
    }
	
	
	
	@GetMapping("reservation/book/{id}")
    public List<UserBookDataDto> reservationBook(@PathVariable Integer id) {
		Optional<Book> optionalBook = bookService.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
				
	        List<Reservation> reservations = book.getReservations();
	
	        List<UserBookDataDto> result = new ArrayList<>();
	        for (Reservation r : reservations) {
	        	if(r.getLent() == null) {
	        		UserBookDataDto dto = new UserBookDataDto();
		            dto.setTitle(r.getBook().getTitle());
		            dto.setAuthor(r.getBook().getAuthor());
		            dto.setDate(r.getDate());
		            
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

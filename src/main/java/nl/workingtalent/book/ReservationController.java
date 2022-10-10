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
public class ReservationController {

	@Autowired
	private ReservationService ReservationService;
	
	@RequestMapping(value = "reservation")
	public List<Reservation> reservationDemo() {
		return ReservationService.printReservationList();
	}
	
	@RequestMapping(value="reservation/register", method = RequestMethod.POST)
	public Reservation register(@RequestBody Reservation reservation) {
		return ReservationService.registerReservation(reservation);
	
	}
	
	@RequestMapping(value="reservation/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
		Optional<Reservation> reservation = ReservationService.findById(id);
        ReservationService.reservationDelete(reservation.get());
    }
	
	
}

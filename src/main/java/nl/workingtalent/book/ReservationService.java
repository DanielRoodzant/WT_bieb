package nl.workingtalent.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository resRepo;
	
	public List<Reservation> printReservationList(){
		return resRepo.findAll();
	}
	
	public Optional<Reservation> findById(Integer id){
		return resRepo.findById(id);
	}
	
	public Reservation registerReservation(Reservation reservation) {
		return resRepo.save(reservation);
	}
	
	public void reservationDelete(Reservation reservation) {
        resRepo.delete(reservation);
    }
}

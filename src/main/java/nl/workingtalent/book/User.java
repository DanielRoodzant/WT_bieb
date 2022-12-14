package nl.workingtalent.book;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// @Entity: moet 1 van kolommen zijn in database, anders geen koppeling database
@Entity
public class User {
// @id: aangeven dat dit gaat om id--> primary key
// @generated value: laten genereren van id overlaten aan database--> colommen (hoeft geen id te geven)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	// @column:	columnlength en of waarde null mag zijn (false=altijd first name)
	@Column(length = 100, nullable = false)
	private String firstName;
	
	@Column(length = 100, nullable = false)
	private String lastName;
	
	@Column(length = 200, nullable = false)
	private String email;
	
	@Column(length = 200, nullable = false)
	private String password;
	
	private boolean admin;

	
	// Relations
	
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations;

	
	// Getters and setters
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}

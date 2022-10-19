package nl.workingtalent.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LentRepository extends JpaRepository<Lent, Integer>{

	// Deze is niet meer nodig want we kunnen de lents ophalen via user
//	@Query("select id from Lent id where id.userId = :userId")
//	public List<Lent> findByUserId(@Param("userId") Integer userId);

}

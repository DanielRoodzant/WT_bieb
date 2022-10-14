package nl.workingtalent.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LentRepository extends JpaRepository<Lent, Integer>{

	@Query("select id from Lent id where id.userId = :userId")
	public Optional<Lent> findByUserId(@Param("userId") Integer userId);
}

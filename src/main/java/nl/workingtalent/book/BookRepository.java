package nl.workingtalent.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{

	// Zoekt op title
	List<Book> findByTitle(String title);

	// Zoekt op title of author
	List<Book> findByTitleLikeOrAuthorLike(String t, String a);
	
}

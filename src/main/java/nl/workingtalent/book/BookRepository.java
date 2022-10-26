package nl.workingtalent.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{

	//zoekt op title
	List<Book> findByTitle(String title);
	List<Book> findByTitleOrAuthorLike(String t, String a);

	// Zoekt op title of author
	List<Book> findByTitleLikeOrAuthorLike(String t, String a);
	

}

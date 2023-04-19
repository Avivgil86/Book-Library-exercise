package app.core.ropos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.enetity.Book;


public interface BookRepos extends JpaRepository<Book, Integer> {

	List<Book> findByLiberyId(int libraryId);

	List<Book> findByReadersId(int readerId);
}
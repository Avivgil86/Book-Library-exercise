package app.core.ropos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.enetity.Book;
import app.core.enetity.Libery;

public interface LiberyRepos extends JpaRepository<Libery, Integer> {
	Libery findByBooksId(int bookId);

	boolean existsByIdAndBooksTitle(int liberyId, String titleBook);

	boolean existsByName(String name);
}

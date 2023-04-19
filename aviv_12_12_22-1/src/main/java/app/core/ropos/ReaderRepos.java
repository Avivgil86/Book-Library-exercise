package app.core.ropos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.enetity.Reader;

public interface ReaderRepos extends JpaRepository<Reader, Integer> {
	List<Reader> findByBooksId(int bookId);
}

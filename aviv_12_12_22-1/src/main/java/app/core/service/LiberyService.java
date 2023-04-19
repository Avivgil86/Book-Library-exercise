package app.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.enetity.Book;
import app.core.enetity.Libery;
import app.core.exeptions.LiberyExeption;
import app.core.ropos.BookRepos;
import app.core.ropos.LiberyRepos;
import app.core.ropos.ReaderRepos;

@Service
@Transactional
public class LiberyService {
	@Autowired
	private BookRepos bookRepos;
	@Autowired
	private LiberyRepos liberyRepos;
	@Autowired
	private ReaderRepos readerRepos;

	public Libery addLibery(Libery libery) throws LiberyExeption {
		if (liberyRepos.existsByName(libery.getName())) {
			throw new LiberyExeption("this libery name is already exists" + libery.getName());
		}
		if (liberyRepos.existsById(libery.getId())) {
			throw new LiberyExeption("this libery  already exists" + libery.getId());
		}
		return libery = liberyRepos.save(libery);
	}

	public void addBookToLibery(Book book, int liberyId) throws LiberyExeption {
		Libery libery = liberyRepos.findById(liberyId)
				.orElseThrow(() -> new LiberyExeption("addBookToLibery fail - libert not found"));
		if (liberyRepos.existsByIdAndBooksTitle(liberyId, book.getTitle())) {
			throw new LiberyExeption("this book already exists");
		}
		libery.addBook(book);
	}

	public Libery findLibery(int liberyId) {
		return liberyRepos.findById(liberyId).orElseThrow();
	}

	public Book findBook(int bookId) {
		return this.bookRepos.findById(bookId).orElseThrow();
	}

	public List<Book> findAllBooks() {
		return this.bookRepos.findAll();
	}

	public List<Book> findAllBooks(int libertId) {
		return this.bookRepos.findByLiberyId(libertId);
	}
}

package app.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.enetity.Book;
import app.core.enetity.Libery;
import app.core.exeptions.LiberyExeption;
import app.core.service.LiberyService;

@RestController
@RequestMapping("/api/libery")
public class LiberyController {
	private LiberyService liberyService;

	@PostMapping("/add")
	public Libery addLibery(@RequestBody Libery libery) {
		try {
			return this.liberyService.addLibery(libery);
		} catch (LiberyExeption e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
	}
	//http://localhost:8080/api/libery/15
@PostMapping("/add-book/{liberyId}")
	public void addBookToLibery(@RequestBody Book book,@PathVariable int liberyId) {
		try {
			this.liberyService.addBookToLibery(book, liberyId);
		} catch (LiberyExeption e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}

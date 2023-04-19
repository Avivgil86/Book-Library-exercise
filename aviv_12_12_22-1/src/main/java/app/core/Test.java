package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.enetity.Book;
import app.core.enetity.Libery;
import app.core.exeptions.LiberyExeption;
import app.core.ropos.LiberyRepos;
import app.core.service.LiberyService;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private LiberyService liberyService;

	Libery libery = new Libery(0, "besor", "Aviv libery", null);
	Libery libery1 = new Libery(0, "Tel aviv", "Mika libery", null);
	Libery libery2 = new Libery(0, "Tel aviv", "Mika libery", null);

	@Override
	public void run(String... args) throws Exception {
		try {
			libery1 = liberyService.addLibery(libery1);
			libery = liberyService.addLibery(libery);
			libery2 = liberyService.addLibery(libery2);
		} catch (LiberyExeption e) {
			System.out.println(e.getMessage());
		}
		try {
			liberyService.addBookToLibery(new Book(0, libery, "Java", "Aviv", null), libery.getId());
			liberyService.addBookToLibery(new Book(0, libery, "Java1", "AvivGil", null), libery.getId());
			liberyService.addBookToLibery(new Book(0, libery, "Java1", "AvivGil", null), libery.getId());
			liberyService.addBookToLibery(new Book(0, libery1, "Java12", "AvivGil1", null), libery1.getId());
		} catch (LiberyExeption e) {
			System.out.println(e.getMessage());
		}
	}

}

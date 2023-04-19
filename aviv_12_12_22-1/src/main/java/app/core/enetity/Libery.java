package app.core.enetity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity

public class Libery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "libery")
	private List<Book> books;

	public Libery() {

	}

	public Libery(int id, String address, String name, List<Book> books) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.books = books;
	}

	public void addBook(Book book) {
		if (books == null) {
			books = new ArrayList<>();
		}
		book.setLibery(this);
		books.add(book);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libery other = (Libery) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Libery [id=" + id + ", address=" + address + ", name=" + name + "]";
	}

}

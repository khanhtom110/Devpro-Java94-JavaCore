package vn.devpro.service;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Author;
import vn.devpro.model.Book;
import vn.devpro.model.Category;

public class BookService {

	public static List<Book> findAll() {
		// TODO Auto-generated method stub
		return LibraryDb.getBooks();
	}

	public static boolean existsByName(String name) {
		// TODO Auto-generated method stub
		for (Book book : LibraryDb.getBooks()) {
			if (name.equalsIgnoreCase(book.getName())) {
				return true;
			}
		}
		return false;
	}

	public static void save(Book book) {
		// TODO Auto-generated method stub
		LibraryDb.getBooks().add(book);
	}

	public static Book getByCode(String code) {
		// TODO Auto-generated method stub
		for (Book book : LibraryDb.getBooks()) {
			if (book.getCode().equals(code)) {
				return book;
			}
		}
		return null;
	}

	public static void update(Book book) {
		// TODO Auto-generated method stub
		int index = findByCode(book.getCode());
		if (index == -1) {
			System.out.println("Co loi xay ra");
			return;
		}
		LibraryDb.getBooks().set(index, book);
	}

	public static int findByCode(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getBooks().size(); i++) {
			if (LibraryDb.getBooks().get(i).getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		LibraryDb.getBooks().remove(index);
	}

	public static void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getBooks().size() - 1; i++) {
			for (int j = LibraryDb.getBooks().size() - 1; j > i; j--) {
				Book currentBook = LibraryDb.getBooks().get(j);
				Book previousBook = LibraryDb.getBooks().get(j - 1);
				if (currentBook.getName().compareTo(previousBook.getName()) < 0) {
					Book tmp = previousBook;
					LibraryDb.getBooks().set(j - 1, currentBook);
					LibraryDb.getBooks().set(j, tmp);
				}
			}
		}
	}

	public static List<Book> getByCategory(String categoryCode) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		Category category = CategoryService.getByCode(categoryCode);
		for (Book book : LibraryDb.getBooks()) {
			if (book.getCategoryId() == category.getId()) {
				books.add(book);
			}
		}
		return books;
	}

	public static List<Book> getByAuthor(String authorCode) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		Author author = AuthorService.getByCode(authorCode);
		for (Book book : LibraryDb.getBooks()) {
			if (book.getAuthorId() == author.getId()) {
				books.add(book);
			}
		}
		return books;
	}

	public static List<Book> getByName(String name) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		name = name.trim();
		for (Book book : LibraryDb.getBooks()) {
			if (book.getName().toLowerCase().contains(name.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	public static Book getById(int bookId) {
		// TODO Auto-generated method stub
		for (Book book : LibraryDb.getBooks()) {
			if (book.getId() == bookId) {
				return book;
			}
		}
		return null;
	}

}
